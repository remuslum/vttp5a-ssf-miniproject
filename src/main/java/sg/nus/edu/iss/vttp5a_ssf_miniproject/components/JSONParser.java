package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;


import java.io.StringReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.CompanyFinancials;
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

    public CompanyFinancials extractMetricsFromJSON(String JSONString){
        JsonObject jsonObject = Json.createReader(new StringReader(JSONString)).readObject();
        JsonObject metric = jsonObject.getJsonObject("metric");
        JsonObject quarterlyNumbers = jsonObject.getJsonObject("series").getJsonObject("quarterly");

        return new CompanyFinancials(metric.getJsonNumber("52WeekHigh").doubleValue(), metric.getString("52WeekHighDate"),
        metric.getJsonNumber("52WeekLow").doubleValue(), metric.getString("52WeekLowDate"), 
        metric.getJsonNumber("beta").doubleValue(), getMetrics("currentRatio", quarterlyNumbers),
        getMetrics("longtermDebtTotalEquity", quarterlyNumbers), getMetrics("testing", quarterlyNumbers));
    }

    private Map<String, Double> getMetrics(String metricName, JsonObject jsonObject){
        Optional<JsonArray> jsonArray = Optional.ofNullable(jsonObject.getJsonArray(metricName));
        Map<String, Double> quarterMap = jsonArray.map((value) -> getMap(value))
        .orElseGet(() -> {
            Map<String, Double> fallBack = new HashMap<>();
            fallBack.put("Information not available", -100.0);
            return fallBack;
        });
        return quarterMap;
    }

    private Map<String, Double> getMap(JsonArray jsonArray){
        Map<String, Double> metricMap = new HashMap<>();
        for(int i = 0; i < 4; i++){
            JsonObject object = jsonArray.getJsonObject(i);
            metricMap.put(object.getString("period"), object.getJsonNumber("v").doubleValue());
        }
        return metricMap;
    } 

}
