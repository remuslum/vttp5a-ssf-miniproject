package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.JSON.JSONParserUser;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.User;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.repo.MapRepo;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.RedisConstants;

@Service
public class SignUpService {
    @Autowired
    JSONParserUser jsonParserUser;

    @Autowired
    MapRepo mapRepo;

    public void addUser(User user){
        mapRepo.create(RedisConstants.REDISUSERSKEY, user.getEmail(), jsonParserUser.convertUserToJSONString(user));
    }

    public boolean doesUserExist(User user){
        return mapRepo.keyExists(RedisConstants.REDISUSERSKEY, user.getEmail());
    }
}
