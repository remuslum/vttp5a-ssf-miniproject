package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSON.JSONParser;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.StockSymbol;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.repo.MapRepo;

@Service
public class StockSymbolService {
    @Autowired
    MapRepo mapRepo;

    @Autowired 
    JSONParser jsonParser;

    public List<StockSymbol> getStockSymbolsFromRedis(String redisKey){
        List<StockSymbol> stockSymbols = new ArrayList<>();

        Map<String, String> symbols = mapRepo.getEntries(redisKey);
        for (Entry<String, String> symbol : symbols.entrySet()){
            stockSymbols.add(jsonParser.convertJSONStringToStockSymbol(symbol.getValue()));
        }
        return stockSymbols;
    }
}
