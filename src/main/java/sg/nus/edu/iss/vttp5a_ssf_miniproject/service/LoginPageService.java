package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSONParserUser;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.PasswordManager;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.User;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.repo.MapRepo;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.RedisConstants;

@Service
public class LoginPageService {
    @Autowired
    PasswordManager passwordManager;

    @Autowired
    JSONParserUser jsonParserUser;

    @Autowired
    MapRepo mapRepo;

    public boolean isValidUser(String email, String password){
        if (mapRepo.keyExists(RedisConstants.REDISUSERSKEY, email)){
            User user = getUser(email);
            return passwordManager.checkPassword(password, user.getPassword());
        }
        return false;
    }

    public User getUser(String email){
        return jsonParserUser.convertJSONToUser(mapRepo.get(RedisConstants.REDISUSERSKEY, email));
    }

}
