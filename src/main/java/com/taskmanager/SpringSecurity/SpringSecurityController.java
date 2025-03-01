package com.taskmanager.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {

    @GetMapping("/")
    public String greet(){
        return "Hi, the application is running";
    }
}
