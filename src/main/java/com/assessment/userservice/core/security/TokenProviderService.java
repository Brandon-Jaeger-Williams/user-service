package com.assessment.userservice.core.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenProviderService {

    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
