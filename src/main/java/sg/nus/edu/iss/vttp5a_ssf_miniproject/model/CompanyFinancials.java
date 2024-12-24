package sg.nus.edu.iss.vttp5a_ssf_miniproject.model;

import java.util.Map;

public class CompanyFinancials {
    private double allTimeHigh;
    private String allTimeHighDate;
    private double allTimeLow;
    private String allTimeLowDate;
    private double beta;
    private Map<String, Double> currentRatio;
    private Map<String, Double> longtermDebtTotalCapital;
    private Map<String, Double> returnOnEquity;

    public CompanyFinancials(double allTimeHigh, String allTimeHighDate, double allTimeLow, String allTimeLowDate,
            double beta, Map<String, Double> currentRatio, Map<String, Double> longtermDebtTotalCapital, Map<String, Double> returnOnEquity) {
        this.allTimeHigh = allTimeHigh;
        this.allTimeHighDate = allTimeHighDate;
        this.allTimeLow = allTimeLow;
        this.allTimeLowDate = allTimeLowDate;
        this.beta = beta;
        this.currentRatio = currentRatio;
        this.longtermDebtTotalCapital = longtermDebtTotalCapital;
        this.returnOnEquity = returnOnEquity;
    }

    public double getAllTimeHigh() {
        return allTimeHigh;
    }

    public void setAllTimeHigh(double allTimeHigh) {
        this.allTimeHigh = allTimeHigh;
    }

    public double getAllTimeLow() {
        return allTimeLow;
    }

    public void setAllTimeLow(double allTimeLow) {
        this.allTimeLow = allTimeLow;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public String getAllTimeHighDate() {
        return allTimeHighDate;
    }

    public void setAllTimeHighDate(String allTimeHighDate) {
        this.allTimeHighDate = allTimeHighDate;
    }

    public String getAllTimeLowDate() {
        return allTimeLowDate;
    }

    public void setAllTimeLowDate(String allTimeLowDate) {
        this.allTimeLowDate = allTimeLowDate;
    }

    @Override
    public String toString(){
        return allTimeHighDate + ":" + allTimeHigh + "\n" + allTimeLowDate + ":" + allTimeLow + "\n" + "beta:" + beta;
    }

    public Map<String, Double> getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(Map<String, Double> currentRatio) {
        this.currentRatio = currentRatio;
    }

    public Map<String, Double> getLongtermDebtTotalCapital() {
        return longtermDebtTotalCapital;
    }

    public void setLongtermDebtTotalCapital(Map<String, Double> longtermDebtTotalCapital) {
        this.longtermDebtTotalCapital = longtermDebtTotalCapital;
    }

    public Map<String, Double> getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(Map<String, Double> returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }
    
}
