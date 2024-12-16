package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSONParser;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.NewsArticle;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.MyConstants;

@Service
public class FinancialDataService {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    JSONParser jsonParser;
    
    public ResponseEntity<String> getMarketNews(){
        String url = UriComponentsBuilder.fromUriString(MyConstants.API_LINK + MyConstants.MARKETNEWS)
        .queryParam("token", apiKey).queryParam("category", "general").toUriString();

        RequestEntity<Void> request = RequestEntity.get(url).build();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(request, String.class);
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
