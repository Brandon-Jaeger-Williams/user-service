package com.assessment.userservice.service;

import com.assessment.userservice.model.AuthResponse;
import com.assessment.userservice.model.LoginRequest;

public interface AuthService {

    AuthResponse login(LoginRequest loginRequest);
}
