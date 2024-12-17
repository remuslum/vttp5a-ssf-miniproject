package sg.nus.edu.iss.vttp5a_ssf_miniproject.model;

public class StockSymbol {
    private String symbol;
    private String description;
    private String type;
    
    public StockSymbol(String symbol, String description, String type) {
        this.symbol = symbol;
        this.description = description;
        this.type = type;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    

    
}
