package com.treniroval.controller;

import com.treniroval.entity.User;
import com.treniroval.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        log.info("createUser : " + user);
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Long id) {
        log.info("getUser : " + id);
        return userService.getUser(id);
    }

    //dropPassword?
}
