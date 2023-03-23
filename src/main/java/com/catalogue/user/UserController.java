package com.catalogue.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // @GetMapping("/all")
    // public ResponseEntity<?> getAllUsers() {
    //     log.info("request all users available");
    //     return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    // }

    @GetMapping("/{user_id}")
    public User getUserById(@PathVariable Long User_id) {
        log.info("request user by ID: {}", User_id);
        return userService.getUserById(User_id);
    }
}
