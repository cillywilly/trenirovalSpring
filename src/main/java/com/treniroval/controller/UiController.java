package com.treniroval.controller;

import com.treniroval.entity.Role;
import com.treniroval.entity.User;
import com.treniroval.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
@EnableJpaRepositories
public class UiController {

    private final UserService userService;

    @GetMapping("/main")
    public String getMain() {
        log.info("you are in!");
        return "main";
    }

    @GetMapping("/registration")
    public String registration(Map<String, Object> model) {
        model.put("message", "");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userService.findByUsername(user.getLogin());
        log.info("findByUsername : " + userFromDb);
        if (userFromDb != null) {
            model.put("message", "User exists!");
            log.info("User exists!");
            return "registration";
        }
        user.setActive(true);
//        user.setEmail(email);
        user.setRoles(Collections.singleton(Role.USER));
        userService.createUser(user);
        log.info("created user : " + user);
        return "redirect:/login";
    }

}
