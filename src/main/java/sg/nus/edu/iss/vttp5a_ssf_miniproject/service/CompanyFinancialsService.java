package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.FScoreCalculator;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSONParserFinancials;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.RequestBuilder;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.CompanyFinancials;

@Service
public class CompanyFinancialsService {
    @Autowired
    RequestBuilder requestBuilder;

    @Autowired
    JSONParserFinancials jsonParserFinancials;

    @Autowired
    FScoreCalculator fScoreCalculator;

    public CompanyFinancials getCompanyFinancials(String symbol){
        ResponseEntity<String> response = requestBuilder.getCompanyFinancials(symbol);
        return jsonParserFinancials.extractMetricsFromJSON(response.getBody());
    }

    public Map<String, String> getFScore(CompanyFinancials companyFinancials){
        List<String> years = new ArrayList<>(companyFinancials.getEbitPerShare().keySet());
        Map<String, String> fScores = new TreeMap<>();

        // Exclude the last year in the table
        for(int i = 1; i < years.size(); i++){
            String currYear = years.get(i);
            fScores.put(currYear, fScoreCalculator.calculateFScore(companyFinancials, currYear));
        }

        return fScores;
    }

}
