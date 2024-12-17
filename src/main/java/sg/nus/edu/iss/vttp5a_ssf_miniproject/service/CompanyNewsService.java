package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSONParser;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.RequestBuilder;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.NewsArticle;

@Service
public class CompanyNewsService {
    @Autowired
    RequestBuilder requestBuilder;

    @Autowired
    JSONParser jsonParser;
    
    public List<NewsArticle> getCompanyNews(String companySymbol){
        List<NewsArticle> companyNews = new ArrayList<>();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");

        ResponseEntity<String> response = requestBuilder.getCompanyNews(companySymbol, startDate.format(formatter), endDate.format(formatter));
        JsonArray jsonArray = Json.createReader(new StringReader(response.getBody())).readArray();

        for(int i = 0; i < jsonArray.size(); i++){
            companyNews.add(jsonParser.convertNewsJSONToNewsArticle(jsonArray.getJsonObject(i)));
        }
        return companyNews;


    }
        
}
