package com.humber.Week8SpringSecurityApp.services;

import com.humber.Week8SpringSecurityApp.models.MyUser;
import com.humber.Week8SpringSecurityApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    // save user to database
    // 0 = failed to save
    // 1 = user saved successfully
    public int saveUser(MyUser user){
        // checks if user even exists through username
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            return 0;
//            throw new RuntimeException("User already exists");
        }
        //encrypt password before saving to database
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return 1;
    }
}
