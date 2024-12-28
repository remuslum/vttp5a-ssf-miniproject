package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.LoginPageService;

@Controller
@RequestMapping
public class LoginPageController {
    @Autowired
    LoginPageService loginPageService;
    
    @GetMapping({"/","/login"})
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView processLoginRequest(HttpSession httpSession, @RequestParam MultiValueMap<String, String> params){
        ModelAndView mav = new ModelAndView();

        String email = params.getFirst("email");
        String password = params.getFirst("password");
        boolean isValidUser = loginPageService.isValidUser(email, password);
        if (isValidUser){
            mav.setViewName("home");
        } else {
            mav.setViewName("login");
        }
        mav.addObject("isValidUser", isValidUser);
        return mav;
    }

}
