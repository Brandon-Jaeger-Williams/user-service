package com.assessment.userservice.service;

import com.assessment.userservice.model.AuthResponse;
import com.assessment.userservice.model.LoginRequest;
import com.assessment.userservice.core.security.TokenProviderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final TokenProviderService tokenProviderService;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        return AuthResponse
                .builder()
                .accessToken(tokenProviderService.generateToken((UserDetails) authentication.getPrincipal()))
                .build();
    }
}
