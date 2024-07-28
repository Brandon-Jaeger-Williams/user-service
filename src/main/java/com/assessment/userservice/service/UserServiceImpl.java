package com.assessment.userservice.service;

import com.assessment.userservice.core.exception.NotFoundException;
import com.assessment.userservice.mapper.UserMapper;
import com.assessment.userservice.model.UserModel;
import com.assessment.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserModel getUser(String username) {
        return UserMapper.mapFrom(userRepository.findByUsername(username).orElseThrow(() ->
                        new NotFoundException("User not found with username: " + username)
                )
        );
    }
}
