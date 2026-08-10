package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.User;
import com.fatmamuge.backend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PreAuthorize("hasRole('GENERAL_MANAGER')")
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PreAuthorize("hasRole('GENERAL_MANAGER')")
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    @PreAuthorize("hasRole('GENERAL_MANAGER')")
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id,
                           @RequestBody User updatedUser) {

        return userService.updateUser(id, updatedUser);
    }
}
