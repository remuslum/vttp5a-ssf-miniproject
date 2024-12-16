package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSONParser;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.RequestBuilder;

@Service
public class StockSymbolService {
    @Autowired
    RequestBuilder requestBuilder;

    @Autowired 
    JSONParser jsonParser;

    public List<String> getStockSymbols(String region){
        List<String> symbolsList = new ArrayList<>();
        String response = requestBuilder.getStockSymbols(region).getBody();
        JsonArray jsonArray = Json.createReader(new StringReader(response)).readArray();
        for(int i = 0; i < jsonArray.size(); i++){
            symbolsList.add(jsonParser.convertSymbolsJSONToList(jsonArray.getJsonObject(i)));
        }
        return symbolsList;
    }
}
