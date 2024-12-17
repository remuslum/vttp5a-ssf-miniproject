package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StockSymbols {
    public List<String> getTop20Symbols(){
        List<String> top20Symbols = new ArrayList<>();

        top20Symbols.add("CNCK");
        top20Symbols.add("WGS");
        top20Symbols.add("TSSI");
        top20Symbols.add("GEAR");
        top20Symbols.add("SEZL");
        top20Symbols.add("FTEL");
        top20Symbols.add("RCAT");
        top20Symbols.add("DOGZ");
        top20Symbols.add("MNPR");
        top20Symbols.add("DAVE");
        top20Symbols.add("QUBT");
        top20Symbols.add("NXL");
        top20Symbols.add("APP");
        top20Symbols.add("UAMY");
        top20Symbols.add("SOUN");
        top20Symbols.add("LSF");
        top20Symbols.add("RGTI");
        top20Symbols.add("NNE");
        top20Symbols.add("ROOT");
        top20Symbols.add("SWVL");

        return top20Symbols;
    }
}
