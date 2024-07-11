package com.assessment.userservice.service;

import com.assessment.userservice.core.security.TokenProviderService;
import com.assessment.userservice.entity.UserEntity;
import com.assessment.userservice.model.AuthResponse;
import com.assessment.userservice.model.LoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AuthServiceImplTest {

    private AuthService authService;

    private final AuthenticationManager authenticationManager = Mockito.mock(AuthenticationManager.class);

    private final TokenProviderService tokenProviderService = Mockito.mock(TokenProviderService.class);

    @BeforeEach
    public void setUp() {
        authService = new AuthServiceImpl(authenticationManager, tokenProviderService);
    }

    @Test
    void test_login_with_valid_user_should_return_auth_response() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test");
        userEntity.setPassword("123");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("test");
        loginRequest.setPassword("123");

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userEntity, userEntity);

        when(authenticationManager.authenticate(any())).thenReturn(authenticationToken);
        when(tokenProviderService.generateToken(any())).thenReturn("token");

        AuthResponse authResponse = authService.login(loginRequest);
        assertNotNull(authResponse);
        assertEquals("token", authResponse.getAccessToken());
    }
}