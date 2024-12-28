package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    
    @GetMapping
    public ModelAndView getSignUpPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("signup");
        return mav;
    }
}
