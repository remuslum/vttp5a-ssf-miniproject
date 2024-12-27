package sg.nus.edu.iss.vttp5a_ssf_miniproject.util;

import java.util.ArrayList;
import java.util.List;

public class AnnualMetrics {

    public static List<String> getMetricsName(){
        List<String> metricsName = new ArrayList<>();
        
        metricsName.add("ebitPerShare");
        metricsName.add("fcfMargin");
        metricsName.add("roa");
        metricsName.add("longtermDebtTotalAsset");
        metricsName.add("currentRatio");
        metricsName.add("grossMargin");
        metricsName.add("inventoryTurnover");

        return metricsName;
    }
}
