package com.taskmanager.SpringSecurity.service;

import com.taskmanager.SpringSecurity.models.UserPrincipal;
import com.taskmanager.SpringSecurity.models.Users;
import com.taskmanager.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Trying to fetch user: " + username);
        Users user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }

        System.out.println("User found: " + user.getUsername());
        System.out.println("Stored password (hashed): " + user.getPassword());

        return new UserPrincipal(user);
    }
}
