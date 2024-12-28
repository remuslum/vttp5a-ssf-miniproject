package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;

import java.io.StringReader;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.User;

@Component
public class JSONParserUser {
    
    public String convertUserToJSONString(User user){
        JsonObject userJsonObject = Json.createObjectBuilder().add("firstName", user.getFirstName())
        .add("lastName", user.getLastName()).add("dateOfBirth", user.getDateOfBirth().toString())
        .add("email", user.getEmail()).add("password", user.getPassword()).build();

        return userJsonObject.toString();
    }

    public User convertJSONToUser(String jsonString){
        JsonObject jsonObject = Json.createReader(new StringReader(jsonString)).readObject();
        return new User(jsonObject.getString("firstName"), jsonObject.getString("lastName"), 
        LocalDate.parse(jsonObject.getString("dateOfBirth")), jsonObject.getString("email"), jsonObject.getString("password"));
    }
}
