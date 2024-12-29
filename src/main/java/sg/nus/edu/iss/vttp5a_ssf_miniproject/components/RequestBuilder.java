package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.APILinks;

@Component
public class RequestBuilder {
    @Value("${api.key}")
    private String apiKey;

    public ResponseEntity<String> getStockSymbols(String region){
        String url = UriComponentsBuilder.fromUriString(APILinks.API_LINK + APILinks.STOCKSYMBOLS)
        .queryParam("exchange", region).queryParam("token", apiKey).toUriString();
        return sendUrlGetRequest(url);
    }

    public ResponseEntity<String> getMarketNews(){
        String url = UriComponentsBuilder.fromUriString(APILinks.API_LINK + APILinks.MARKETNEWS)
        .queryParam("token", apiKey).queryParam("category", "general").toUriString();

        return sendUrlGetRequest(url);  
    }

    public ResponseEntity<String> getCompanyNews(String symbol, String from, String to){
        String url = UriComponentsBuilder.fromUriString(APILinks.API_LINK + APILinks.COMPANYNEWS)
        .queryParam("token", apiKey).queryParam("symbol", symbol).queryParam("from", from)
        .queryParam("to", to).toUriString();

        return sendUrlGetRequest(url);
    }

    public ResponseEntity<String> getCompanyFinancials(String symbol){
        String url = UriComponentsBuilder.fromUriString(APILinks.API_LINK + APILinks.COMPANYFINANCIALS)
        .queryParam("token", apiKey).queryParam("symbol",symbol).queryParam("metric", "all")
        .toUriString();

        return sendUrlGetRequest(url);
    }

    public ResponseEntity<String> getInsideInformation(String symbol){
        String url = UriComponentsBuilder.fromUriString(APILinks.API_LINK + APILinks.INSIDERINFORMATION)
        .queryParam("token", apiKey).queryParam("symbol", symbol).toUriString();

        return sendUrlGetRequest(url);
    }

    private ResponseEntity<String> sendUrlGetRequest(String url){
        RequestEntity<Void> request = RequestEntity.get(url).build();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(request, String.class);
    }


}
