package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSONParser;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSONParserInsideInformation;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.RequestBuilder;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.InsideInformation;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.NewsArticle;

@Service
public class CompanyNewsService {
    @Autowired
    RequestBuilder requestBuilder;

    @Autowired
    JSONParser jsonParser;

    @Autowired
    JSONParserInsideInformation jsonParserInsideInformation;
    
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

    public List<InsideInformation> getInsideInformation(String companySymbol){
        List<InsideInformation> insiders = new ArrayList<>();
        ResponseEntity<String> response = requestBuilder.getInsideInformation(companySymbol);
        JsonObject jsonObject = Json.createReader(new StringReader(response.getBody())).readObject();
        JsonArray jsonArray = jsonObject.getJsonArray("data");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for(int i = 0; i < jsonArray.size(); i++){
            String date = jsonArray.getJsonObject(i).getString("filingDate");
            LocalDate dateOfTransaction = LocalDate.parse(date, formatter);
            long monthsBetween = ChronoUnit.MONTHS.between(dateOfTransaction, LocalDate.now());

            if(monthsBetween < 1){
                insiders.add(jsonParserInsideInformation.convertJSONToInsideInformation(jsonArray.getJsonObject(i).toString()));
            }
        }
        return insiders;
    }
        
}
