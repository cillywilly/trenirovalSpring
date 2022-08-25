package com.treniroval.controller;

import com.treniroval.entity.User;
import com.treniroval.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createUser() {
        userService.createUser(new User("admin", "admin"));
    }

    @GetMapping("/user")
    public User getUser() {
        return userService.getUser(1);
    }

}
