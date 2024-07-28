package com.assessment.userservice.service;

import com.assessment.userservice.model.UserModel;

public interface UserService {

    UserModel getUser(String username);
}
