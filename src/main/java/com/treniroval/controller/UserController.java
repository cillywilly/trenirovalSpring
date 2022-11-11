package com.treniroval.controller;

import com.treniroval.entity.User;
import com.treniroval.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createUpdateUser(@RequestBody User user) {
        return userService.createUpdateUser(user);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Long id) {
        return userService.getUser(id);
    }

    //dropPassword?
}
