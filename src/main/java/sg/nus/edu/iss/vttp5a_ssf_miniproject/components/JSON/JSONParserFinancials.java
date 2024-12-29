package sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSON;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.converter.DoubleFormatter;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.converter.LocalDateConverter;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.CompanyFinancials;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.AnnualMetrics;

@Component
public class JSONParserFinancials {
    @Autowired
    DoubleFormatter doubleFormatter;

    @Autowired
    LocalDateConverter localDateConverter;

    public CompanyFinancials extractMetricsFromJSON(String JSONString){
        JsonObject jsonObject = Json.createReader(new StringReader(JSONString)).readObject();
        JsonObject metric = jsonObject.getJsonObject("metric");
        JsonObject annualNumbers = jsonObject.getJsonObject("series").getJsonObject("annual");
        
        Map<String, Map<String, Double>> annualMetrics = new HashMap<>();
        for(String metricName:AnnualMetrics.getMetricsName()){
            annualMetrics.put(metricName, getMetrics(metricName, annualNumbers));
        }

        return new CompanyFinancials(doubleFormatter.convertTo2DecimalPlaces(metric.getJsonNumber("52WeekHigh").doubleValue()), metric.getString("52WeekHighDate"),
        doubleFormatter.convertTo2DecimalPlaces(metric.getJsonNumber("52WeekLow").doubleValue()), metric.getString("52WeekLowDate"), 
        doubleFormatter.convertTo2DecimalPlaces(metric.getJsonNumber("beta").doubleValue()), annualMetrics.get("ebitPerShare"),
        annualMetrics.get("fcfMargin"), annualMetrics.get("roa"), annualMetrics.get("longtermDebtTotalAsset"), annualMetrics.get("currentRatio"),
        annualMetrics.get("grossMargin"),annualMetrics.get("inventoryTurnover"));
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
        Map<String, Double> metricMap = new TreeMap<>();
        // Extract info from past 5 years or all the info, depending on what is smaller to prevent ArrayOutOfBounds exception
        int lengthNeeded = Math.min(jsonArray.size(), 5);
        
        for(int i = 0; i < lengthNeeded; i++){
            JsonObject object = jsonArray.getJsonObject(i);
            String yearOfPeriod = localDateConverter.extractYearFromDate(object.getString("period"));
            metricMap.put(yearOfPeriod, object.getJsonNumber("v").doubleValue());
        }
        return metricMap;
    }
}
