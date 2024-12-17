package sg.nus.edu.iss.vttp5a_ssf_miniproject.service.restservice;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.RequestBuilder;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.StockSymbols;
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
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            if(stockSymbols.getTop20Symbols().contains(jsonObject.getString("symbol"))){
                mapRepo.create(RedisConstants.REDISKEY, jsonObject.getString("symbol"), jsonObject.toString());
            }
            
        }
        return true;
    }
}
