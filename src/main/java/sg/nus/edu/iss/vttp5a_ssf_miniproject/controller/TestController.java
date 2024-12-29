package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    
    @GetMapping
    public String test(){
        return "test";
    }
}
