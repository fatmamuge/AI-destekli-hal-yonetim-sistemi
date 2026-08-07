package com.fatmamuge.backend.service;

import com.fatmamuge.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.fatmamuge.backend.dto.LoginRequest;
import com.fatmamuge.backend.entity.User;
import com.fatmamuge.backend.dto.LoginResponse;
import com.fatmamuge.backend.security.JwtService;


@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginService(UserRepository userRepository,
                    PasswordEncoder passwordEncoder,
		    JwtService jwtService) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPasswordHash())) {

        throw new RuntimeException("Invalid password");
    }

        String token = jwtService.generateToken(user);
	return new LoginResponse(token);
    }

}
