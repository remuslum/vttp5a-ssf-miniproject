package sg.nus.edu.iss.vttp5a_ssf_miniproject.model;

import java.util.Map;

public class CompanyFinancials {
    private double allTimeHigh;
    private String allTimeHighDate;
    private double allTimeLow;
    private String allTimeLowDate;
    private double beta;
    private Map<String, Double> priceEarnings;
    private Map<String, Double> priceBook;
    private Map<String, Double> currentRatio;
    private Map<String, Double> cashRatio;
    private Map<String, Double> earningsPerShare;
    private Map<String, Double> returnOnEquity;
    private Map<String, Double> debtToEquity;
    private Map<String, Double> debtToCapital;

    

    public CompanyFinancials(double allTimeHigh, String allTimeHighDate, double allTimeLow, String allTimeLowDate,
            double beta, Map<String, Double> priceEarnings, Map<String, Double> priceBook,
            Map<String, Double> currentRatio, Map<String, Double> cashRatio, Map<String, Double> earningsPerShare,
            Map<String, Double> returnOnEquity, Map<String, Double> debtToEquity, Map<String, Double> debtToCapital) {
        this.allTimeHigh = allTimeHigh;
        this.allTimeHighDate = allTimeHighDate;
        this.allTimeLow = allTimeLow;
        this.allTimeLowDate = allTimeLowDate;
        this.beta = beta;
        this.priceEarnings = priceEarnings;
        this.priceBook = priceBook;
        this.currentRatio = currentRatio;
        this.cashRatio = cashRatio;
        this.earningsPerShare = earningsPerShare;
        this.returnOnEquity = returnOnEquity;
        this.debtToEquity = debtToEquity;
        this.debtToCapital = debtToCapital;
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

    public Map<String, Double> getPriceEarnings() {
        return priceEarnings;
    }

    public void setPriceEarnings(Map<String, Double> priceEarnings) {
        this.priceEarnings = priceEarnings;
    }

    public Map<String, Double> getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(Map<String, Double> priceBook) {
        this.priceBook = priceBook;
    }

    public Map<String, Double> getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(Map<String, Double> currentRatio) {
        this.currentRatio = currentRatio;
    }

    public Map<String, Double> getCashRatio() {
        return cashRatio;
    }

    public void setCashRatio(Map<String, Double> cashRatio) {
        this.cashRatio = cashRatio;
    }

    public Map<String, Double> getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(Map<String, Double> earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
    }

    public Map<String, Double> getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(Map<String, Double> returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }

    public Map<String, Double> getDebtToEquity() {
        return debtToEquity;
    }

    public void setDebtToEquity(Map<String, Double> debtToEquity) {
        this.debtToEquity = debtToEquity;
    }

    public Map<String, Double> getDebtToCapital() {
        return debtToCapital;
    }

    public void setDebtToCapital(Map<String, Double> debtToCapital) {
        this.debtToCapital = debtToCapital;
    }

    @Override
    public String toString(){
        return allTimeHighDate + ":" + allTimeHigh + "\n" + allTimeLowDate + ":" + allTimeLow + "\n" + "beta:" + beta;
    }
}
