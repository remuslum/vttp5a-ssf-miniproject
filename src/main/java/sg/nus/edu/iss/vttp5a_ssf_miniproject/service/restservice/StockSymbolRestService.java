package sg.nus.edu.iss.vttp5a_ssf_miniproject.service.restservice;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.requestbuilder.RequestBuilder;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.symbols.StockSymbols;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.repo.MapRepo;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.RedisConstants;

@Service
public class StockSymbolRestService {
    @Autowired
    RequestBuilder requestBuilder;

    @Autowired
    MapRepo mapRepo;

    @Autowired 
    StockSymbols stockSymbols;

    public boolean getStockSymbols(){
        String response = requestBuilder.getStockSymbols("US").getBody();
        JsonArray jsonArray = Json.createReader(new StringReader(response)).readArray();
        Map<String, String> symbolsMap = stockSymbols.getTop10Symbols();
        List<String> symbols = new ArrayList<>(symbolsMap.keySet());

        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            String symbolFromJSON = jsonObject.getString("symbol");
            if(symbols.contains(symbolFromJSON)){
                JsonObject finalJsonObject = Json.createObjectBuilder(jsonObject).add("image", symbolsMap.get(symbolFromJSON)).build();
                mapRepo.create(RedisConstants.REDISKEY, jsonObject.getString("symbol"), finalJsonObject.toString());
            }
            
        }
        return true;
    }
}
