package com.treniroval.controller;

import com.treniroval.entity.Role;
import com.treniroval.entity.User;
import com.treniroval.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class UiController {

    private final UserService userService;

    public UiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/main")
    public String getMain() {
        return "main";
    }

    @GetMapping("/registration")
    public String registration(Map<String, Object> model) {
        model.put("message", "");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model, @RequestParam String email) {
        User userFromDb = userService.getUserByLogin(user.getLogin());
        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setEmail(email);
        user.setRoles(Collections.singleton(Role.USER));
        userService.createUpdateUser(user);
        return "redirect:/login";
    }

}
