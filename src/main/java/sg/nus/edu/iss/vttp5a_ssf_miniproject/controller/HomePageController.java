package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.User;

@Controller
@RequestMapping("/home")
public class HomePageController {
    
    @GetMapping
    public ModelAndView displayHomePage(HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Optional<User> user = Optional.ofNullable((User)httpSession.getAttribute("user"));
        user.ifPresentOrElse(
            (value) -> {
            mav.addObject("user", value);
            mav.setViewName("home");
            }, 
            () -> mav.setViewName("error"));
        return mav;
    }
}
