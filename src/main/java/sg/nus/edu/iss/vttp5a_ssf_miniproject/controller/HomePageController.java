package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomePageController {
    
    @GetMapping
    public ModelAndView displayHomePage(HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        // User user = (User) httpSession.getAttribute("user");
        // String username = new StringBuilder().append(user.getFirstName()).append(" ").append(user.getLastName()).toString();
        // mav.addObject("username", username);
        mav.setViewName("home");
        return mav;
    }
}
