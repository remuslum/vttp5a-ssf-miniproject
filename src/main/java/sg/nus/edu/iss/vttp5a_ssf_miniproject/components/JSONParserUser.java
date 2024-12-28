package sg.nus.edu.iss.vttp5a_ssf_miniproject.components;

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
}
