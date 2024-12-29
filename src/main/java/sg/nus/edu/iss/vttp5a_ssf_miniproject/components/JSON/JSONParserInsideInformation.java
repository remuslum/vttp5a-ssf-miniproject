package sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSON;

import java.io.StringReader;

import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.InsideInformation;

@Component
public class JSONParserInsideInformation {
    public InsideInformation convertJSONToInsideInformation(String jsonString){
        JsonObject object = Json.createReader(new StringReader(jsonString)).readObject();
        return new InsideInformation(object.getString("filingDate"), object.getString("id"), object.getString("name"),
        object.getString("source"), object.getString("transactionCode"), object.getJsonNumber("transactionPrice").doubleValue());
    }
}
