package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginPageController {
    
    @GetMapping
    public String getLoginPage(){
        return "login";
    }
}
