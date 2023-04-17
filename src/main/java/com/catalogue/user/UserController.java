package com.catalogue.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        log.info("request all users available");
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public User getUserById(@PathVariable Long user_id) {
        log.info("request user by ID: {}", user_id);
        return userService.getUserById(user_id);
    }

    @PostMapping("/register")
    public Long register(@RequestBody User user) {
        log.info("register new user");
        return userService.registerNewUser(user);
    }

    @PostMapping("/register2")
    public String register() {
        log.info("register new user");
        return "hello from user service";
    }
}
