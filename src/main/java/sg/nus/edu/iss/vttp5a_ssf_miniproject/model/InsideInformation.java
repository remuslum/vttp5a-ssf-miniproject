package sg.nus.edu.iss.vttp5a_ssf_miniproject.model;

public class InsideInformation {
    private String filingDate;
    private String id;
    private String name;
    private String source;
    private String transactionCode;
    private double transactionPrice;
    
    public InsideInformation(String filingDate, String id, String name, String source, String transactionCode,
            double transactionPrice) {
        this.filingDate = filingDate;
        this.id = id;
        this.name = name;
        this.source = source;
        this.transactionCode = transactionCode;
        this.transactionPrice = transactionPrice;
    }
    public String getFilingDate() {
        return filingDate;
    }
    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getTransactionCode() {
        return transactionCode;
    }
    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }
    public double getTransactionPrice() {
        return transactionPrice;
    }
    public void setTransactionPrice(double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    
}
