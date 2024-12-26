package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StockSymbols {
    public List<String> getTop10Symbols(){
        List<String> top10symbols = new ArrayList<>();

        top10symbols.add("NVDA");
        top10symbols.add("AAPL");
        top10symbols.add("MSFT");
        top10symbols.add("GOOGL");
        top10symbols.add("AMZN");
        top10symbols.add("XOM");
        top10symbols.add("GE");
        top10symbols.add("IBM");
        top10symbols.add("JNJ");
        top10symbols.add("PG");
        return top10symbols;
    }
}
