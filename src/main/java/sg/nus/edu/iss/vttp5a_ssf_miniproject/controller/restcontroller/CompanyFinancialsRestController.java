package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.CompanyFinancialsService;

@RestController
@RequestMapping("/financials")
public class CompanyFinancialsRestController {
    @Autowired
    CompanyFinancialsService companyFinancialsService;

    @GetMapping("/{company-symbol}")
    public ResponseEntity<String> getCompanyFinancials(@PathVariable("company-symbol") String companySymbol){
        return ResponseEntity.ok().body(companyFinancialsService.getCompanyFinancials(companySymbol).toString());
    }
}
