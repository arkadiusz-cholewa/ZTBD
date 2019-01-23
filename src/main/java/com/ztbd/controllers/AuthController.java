package com.ztbd.controllers;

import com.ztbd.models.User;
import com.ztbd.repositories_mongodb.UserNoSQLRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private UserNoSQLRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(UserNoSQLRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}