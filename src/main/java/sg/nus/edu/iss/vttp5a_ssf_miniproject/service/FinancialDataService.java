package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import java.io.StringReader;
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
public class FinancialDataService {
    @Autowired
    RequestBuilder requestBuilder;

    @Autowired
    JSONParser jsonParser;
    
    public ResponseEntity<String> getMarketNews(){
        return requestBuilder.getMarketNews();
    }

    public List<NewsArticle> getNewsArticleList() {
        String response = getMarketNews().getBody();
        List<NewsArticle> newsArticles = new ArrayList<>();

        JsonArray jsonArray = Json.createReader(new StringReader(response)).readArray();
        for(int i = 0; i < jsonArray.size(); i++){
            newsArticles.add(jsonParser.convertNewsJSONToNewsArticle(jsonArray.getJsonObject(i)));
        }
        return newsArticles;
        
    }
}
