package sg.nus.edu.iss.vttp5a_ssf_miniproject.components.converter;

import org.springframework.stereotype.Component;

@Component
public class DoubleFormatter {
    
    public double convertTo2DecimalPlaces(double number){
        return Math.round(number * 100.0)/100.0 ;
    }
}
