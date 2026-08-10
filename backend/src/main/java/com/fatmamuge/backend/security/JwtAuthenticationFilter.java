package com.fatmamuge.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.fatmamuge.backend.entity.User;
import com.fatmamuge.backend.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UserRepository userRepository) {

        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

	System.out.println("REQUEST: " + request.getMethod() + " " + request.getRequestURI());
System.out.println("AUTH HEADER: " + authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

	if (jwtService.isTokenValid(token)) {
		String phoneNumber = jwtService.extractPhoneNumber(token);
		String role = jwtService.extractRole(token);

		System.out.println("Phone: " + phoneNumber);
		System.out.println("Role: " + role);

		User user = userRepository
			.findByPhoneNumber(phoneNumber)
			.orElse(null);
		if (user != null) {
			UsernamePasswordAuthenticationToken authentication =
				new UsernamePasswordAuthenticationToken(
						user,
						null,
						java.util.List.of(
							new org.springframework.security.core.authority.SimpleGrantedAuthority(
								"ROLE_" + role.toUpperCase().replace(" ", "_")
							)
						)
				);
			SecurityContextHolder
				.getContext()
				.setAuthentication(authentication);
		}
	}


        filterChain.doFilter(request, response);
    }
}
