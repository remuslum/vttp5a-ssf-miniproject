package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomePageController {
    
    @GetMapping
    public ModelAndView displayHomePage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
}
