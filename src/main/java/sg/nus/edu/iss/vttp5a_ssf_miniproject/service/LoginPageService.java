package sg.nus.edu.iss.vttp5a_ssf_miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.components.PasswordManager;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.repo.MapRepo;

@Service
public class LoginPageService {
    @Autowired
    PasswordManager passwordManager;

    @Autowired
    MapRepo mapRepo;

}
