package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.FinancialDataService;


@RestController
@RequestMapping("/news")
public class FinancialDataController {
    @Autowired
    FinancialDataService financialDataService;
    
    @GetMapping
    public ResponseEntity<String> getFinancialNews() {
        return financialDataService.getMarketNews();
    }
    
    
}
