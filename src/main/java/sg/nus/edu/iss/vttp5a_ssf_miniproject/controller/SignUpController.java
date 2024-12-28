package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.PasswordManager;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.User;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.SignUpService;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    SignUpService signUpService;

    @Autowired
    PasswordManager passwordManager;
    
    @GetMapping
    public ModelAndView getSignUpPage(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", new User());
        mav.setViewName("signup");
        return mav;
    }

    @PostMapping
    public ModelAndView signUserUp(@Valid User user, BindingResult bindingResult, HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        boolean doesUserExist = signUpService.doesUserExist(user);
        mav.addObject("checkUserExist", doesUserExist);

        if(bindingResult.hasErrors() || doesUserExist){
            mav.setViewName("signup");
        } 
        else {
            long yearsBetween = ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now());
            if(yearsBetween < 18){
                FieldError error = new FieldError("user", "dateOfBirth", "You must be at least 18 years to register an account with us");
                bindingResult.addError(error);
                mav.setViewName("signup");
            } else {
                String hashedPassword = passwordManager.hashPassword(user.getPassword());
                User newUser = new User(user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getEmail(), hashedPassword);
                signUpService.addUser(newUser);
                httpSession.setAttribute("user", newUser);
                mav.setViewName("home");
            }
            
        }
        return mav;
    }
}
