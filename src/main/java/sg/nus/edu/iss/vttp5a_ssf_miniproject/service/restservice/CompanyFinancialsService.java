package sg.nus.edu.iss.vttp5a_ssf_miniproject.service.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSONParser;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.RequestBuilder;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.CompanyFinancials;

@Service
public class CompanyFinancialsService {
    @Autowired
    RequestBuilder requestBuilder;

    @Autowired
    JSONParser jsonParser;

    public CompanyFinancials getCompanyFinancials(String symbol){
        ResponseEntity<String> response = requestBuilder.getCompanyFinancials(symbol);
        return jsonParser.extractMetricsFromJSON(response.getBody());
    }
}
