package sg.nus.edu.iss.vttp5a_ssf_miniproject.components.calculator;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.CompanyFinancials;

@Component
public class FScoreCalculator {
    
    public String calculateFScore(CompanyFinancials companyFinancials, String year){
        int fScore = isMetricPositive(companyFinancials.getEbitPerShare(), year) + isMetricPositive(companyFinancials.getFcfMargin(), year) + 
        isEarningsJustified(companyFinancials, year) + isMetricPositive(companyFinancials.getCurrentRatio(), year)
        + isThereADrop(companyFinancials.getLongtermDebtTotalAsset(), year) + isThereImprovement(companyFinancials.getCurrentRatio(), year)
        + isThereImprovement(companyFinancials.getGrossMargin(), year) + isThereImprovement(companyFinancials.getInventoryTurnover(), year);

        return String.valueOf(fScore);
    }

    private int isEarningsJustified(CompanyFinancials companyFinancials, String year){
        Map<String, Double> ebitPerShare = companyFinancials.getEbitPerShare();
        Map<String, Double> fcfMargin = companyFinancials.getFcfMargin();

        Double ebitValue = Optional.ofNullable(ebitPerShare.get(year)).orElse(0.00);
        Double fcfValue = Optional.ofNullable(fcfMargin.get(year)).orElse(0.00);
        return Boolean.compare(fcfValue > ebitValue, false);
    }

    private int isMetricPositive(Map<String, Double> metric, String year){
        Optional<Double> value = Optional.ofNullable(metric.get(year));
        int result = value.map(x -> Boolean.compare(x > 0.00, false)).orElse(0);
        return result;
    }

    private int isThereADrop(Map<String, Double> metric, String year){
        String prevYear = String.valueOf(Integer.parseInt(year) - 1);

        // If data is missing, we will make the comparator equate to always false
        Double currYearMetric = Optional.ofNullable(metric.get(year)).orElse(Double.POSITIVE_INFINITY);
        Double prevYearMetric = Optional.ofNullable(metric.get(prevYear)).orElse(Double.NEGATIVE_INFINITY);
        return Boolean.compare(currYearMetric < prevYearMetric, false);
    }

    private int isThereImprovement(Map<String, Double> metric, String year){
        String prevYear = String.valueOf(Integer.parseInt(year) - 1);

        // If data is missing, we will make the comparator equate to always false
        Double currYearMetric = Optional.ofNullable(metric.get(year)).orElse(Double.NEGATIVE_INFINITY);
        Double prevYearMetric = Optional.ofNullable(metric.get(prevYear)).orElse(Double.POSITIVE_INFINITY);
        return Boolean.compare(currYearMetric > prevYearMetric, false);
    }

}
