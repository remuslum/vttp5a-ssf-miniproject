package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/logout")
public class LogoutController {
    
    @GetMapping()
    public String logUserOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }
    
}
