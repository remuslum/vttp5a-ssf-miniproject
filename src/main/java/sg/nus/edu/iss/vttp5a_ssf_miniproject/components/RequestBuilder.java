package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.MyConstants;

@Component
public class RequestBuilder {
    @Value("${api.key}")
    private String apiKey;

    public ResponseEntity<String> getStockSymbols(String region){
        String url = UriComponentsBuilder.fromUriString(MyConstants.API_LINK + MyConstants.STOCKSYMBOLS)
        .queryParam("exchange", region).queryParam("token", apiKey).toUriString();
        return sendUrlGetRequest(url);
    }

    public ResponseEntity<String> getMarketNews(){
        String url = UriComponentsBuilder.fromUriString(MyConstants.API_LINK + MyConstants.MARKETNEWS)
        .queryParam("token", apiKey).queryParam("category", "general").toUriString();

        return sendUrlGetRequest(url);  
    }

    private ResponseEntity<String> sendUrlGetRequest(String url){
        RequestEntity<Void> request = RequestEntity.get(url).build();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(request, String.class);
    }
}
