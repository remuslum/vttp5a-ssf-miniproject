package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;


import java.io.StringReader;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.NewsArticle;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.StockSymbol;

@Component
public class JSONParser {
    @Autowired
    LocalDateConverter localDateConverter;

    public NewsArticle convertNewsJSONToNewsArticle(JsonObject jsonObject){
        LocalDate newsDate = localDateConverter.convert(jsonObject.getJsonNumber("datetime").longValue());

        return new NewsArticle(jsonObject.getString("category"), newsDate, jsonObject.getString("headline")
        , jsonObject.getInt("id"), jsonObject.getString("image"), jsonObject.getString("related")
        , jsonObject.getString("source"), jsonObject.getString("summary"), jsonObject.getString("url"));
        
    }

    public StockSymbol convertJSONStringToStockSymbol(String JSONString){
        JsonObject jsonObject = Json.createReader(new StringReader(JSONString)).readObject();
        return new StockSymbol(jsonObject.getString("symbol"), jsonObject.getString("description"), jsonObject.getString("type"));
    }

}
