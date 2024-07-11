package com.assessment.userservice.mapper;

import com.assessment.userservice.entity.UserEntity;
import com.assessment.userservice.model.UserModel;

public class UserMapper {

    public static UserModel mapFrom(UserEntity user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());
        return userModel;
    }
}
