package sg.nus.edu.iss.vttp5a_ssf_miniproject.util;

import java.util.ArrayList;
import java.util.List;

public class QuarterlyMetrics {

    public static List<String> getMetricsName(){
        List<String> metricsName = new ArrayList<>();
        
        metricsName.add("eps");
        metricsName.add("roeTTM");
        metricsName.add("peTTM");
        metricsName.add("pb");
        metricsName.add("cashRatio");
        metricsName.add("currentRatio");
        metricsName.add("netDebtToTotalEquity");
        metricsName.add("netDebtToTotalCapital");

        return metricsName;
    }
}
