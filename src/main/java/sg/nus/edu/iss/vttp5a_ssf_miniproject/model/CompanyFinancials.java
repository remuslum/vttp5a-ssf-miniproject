package sg.nus.edu.iss.vttp5a_ssf_miniproject.model;

import java.util.Map;

public class CompanyFinancials {
    private double allTimeHigh;
    private String allTimeHighDate;
    private double allTimeLow;
    private String allTimeLowDate;
    private double beta;
    private Map<String, Double> ebitPerShare;
    private Map<String, Double> fcfMargin;
    private Map<String, Double> returnOnAsset;
    private Map<String, Double> longtermDebtTotalAsset;
    private Map<String, Double> currentRatio;
    private Map<String, Double> grossMargin;
    private Map<String, Double> inventoryTurnover;

    public CompanyFinancials(double allTimeHigh, String allTimeHighDate, double allTimeLow, String allTimeLowDate,
            double beta, Map<String, Double> ebitPerShare, Map<String, Double> fcfMargin,
            Map<String, Double> returnOnAsset, Map<String, Double> longtermDebtTotalAsset,
            Map<String, Double> currentRatio, Map<String, Double> grossMargin, Map<String, Double> inventoryTurnover) {
        this.allTimeHigh = allTimeHigh;
        this.allTimeHighDate = allTimeHighDate;
        this.allTimeLow = allTimeLow;
        this.allTimeLowDate = allTimeLowDate;
        this.beta = beta;
        this.ebitPerShare = ebitPerShare;
        this.fcfMargin = fcfMargin;
        this.returnOnAsset = returnOnAsset;
        this.longtermDebtTotalAsset = longtermDebtTotalAsset;
        this.currentRatio = currentRatio;
        this.grossMargin = grossMargin;
        this.inventoryTurnover = inventoryTurnover;
    }

    public CompanyFinancials() {

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

    public Map<String, Double> getEbitPerShare() {
        return ebitPerShare;
    }

    public void setEbitPerShare(Map<String, Double> ebitPerShare) {
        this.ebitPerShare = ebitPerShare;
    }

    public Map<String, Double> getFcfMargin() {
        return fcfMargin;
    }

    public void setFcfMargin(Map<String, Double> fcfMargin) {
        this.fcfMargin = fcfMargin;
    }

    public Map<String, Double> getReturnOnAsset() {
        return returnOnAsset;
    }

    public void setReturnOnAsset(Map<String, Double> returnOnAsset) {
        this.returnOnAsset = returnOnAsset;
    }

    public Map<String, Double> getLongtermDebtTotalAsset() {
        return longtermDebtTotalAsset;
    }

    public void setLongtermDebtTotalAsset(Map<String, Double> longtermDebtTotalAsset) {
        this.longtermDebtTotalAsset = longtermDebtTotalAsset;
    }

    public Map<String, Double> getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(Map<String, Double> currentRatio) {
        this.currentRatio = currentRatio;
    }

    public Map<String, Double> getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(Map<String, Double> grossMargin) {
        this.grossMargin = grossMargin;
    }

    public Map<String, Double> getInventoryTurnover() {
        return inventoryTurnover;
    }

    public void setInventoryTurnover(Map<String, Double> inventoryTurnover) {
        this.inventoryTurnover = inventoryTurnover;
    }

    @Override
    public String toString(){
        return allTimeHighDate + ":" + allTimeHigh + "\n" + allTimeLowDate + ":" + allTimeLow + "\n" + "beta:" + beta;
    }
}
