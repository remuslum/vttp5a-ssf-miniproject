package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.CompanyFinancials;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.QuarterlyMetrics;

@Component
public class JSONParserFinancials {
    @Autowired
    DoubleFormatter doubleFormatter;

    public CompanyFinancials extractMetricsFromJSON(String JSONString){
        JsonObject jsonObject = Json.createReader(new StringReader(JSONString)).readObject();
        JsonObject metric = jsonObject.getJsonObject("metric");
        JsonObject quarterlyNumbers = jsonObject.getJsonObject("series").getJsonObject("quarterly");
        
        Map<String, Map<String, Double>> quarterlyMetrics = new HashMap<>();
        for(String metricName:QuarterlyMetrics.getMetricsName()){
            quarterlyMetrics.put(metricName, getMetrics(metricName, quarterlyNumbers));
        }

        return new CompanyFinancials(doubleFormatter.convertTo2DecimalPlaces(metric.getJsonNumber("52WeekHigh").doubleValue()), metric.getString("52WeekHighDate"),
        doubleFormatter.convertTo2DecimalPlaces(metric.getJsonNumber("52WeekLow").doubleValue()), metric.getString("52WeekLowDate"), 
        doubleFormatter.convertTo2DecimalPlaces(metric.getJsonNumber("beta").doubleValue()), quarterlyMetrics.get("peTTM"),
        quarterlyMetrics.get("pb"), quarterlyMetrics.get("currentRatio"), quarterlyMetrics.get("cashRatio"), quarterlyMetrics.get("eps"),
        quarterlyMetrics.get("roeTTM"),quarterlyMetrics.get("netDebtToTotalEquity"),quarterlyMetrics.get("netDebtToTotalCapital"));
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
