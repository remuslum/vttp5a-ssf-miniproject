package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class StockSymbols {
    private final String pathToImages = "/images";

    public Map<String, String> getTop10Symbols(){
        Map<String, String> top10symbols = new HashMap<>();
        
        top10symbols.put("NVDA",pathToImages + "/nvidia_logo.png");
        top10symbols.put("AAPL",pathToImages + "/apple_logo.png");
        top10symbols.put("MSFT",pathToImages + "microsoft_logo.jpg");
        top10symbols.put("GOOGL",pathToImages + "/google_logo.png");
        top10symbols.put("AMZN",pathToImages + "/amazon_logo.jpg");
        top10symbols.put("XOM",pathToImages + "/Exxon_Mobil_Logo.svg.png");
        top10symbols.put("GE",pathToImages + "/General_Electric_logo.svg.png");
        top10symbols.put("IBM",pathToImages + "/IBM_logo.svg.png");
        top10symbols.put("JNJ",pathToImages + "/jnj_logo.png");
        top10symbols.put("PG",pathToImages + "/Procter_&_Gamble_logo.svg.png");

        return top10symbols;
    }
}
