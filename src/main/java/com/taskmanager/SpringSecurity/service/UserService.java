package com.taskmanager.SpringSecurity.service;

import com.taskmanager.SpringSecurity.models.Users;
import com.taskmanager.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public Users save(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
