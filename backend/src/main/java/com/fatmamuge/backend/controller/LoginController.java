package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.dto.LoginRequest;
import com.fatmamuge.backend.entity.User;
import com.fatmamuge.backend.service.LoginService;
import org.springframework.web.bind.annotation.*;
import com.fatmamuge.backend.dto.LoginResponse;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
	 return loginService.login(request);
    }
}
