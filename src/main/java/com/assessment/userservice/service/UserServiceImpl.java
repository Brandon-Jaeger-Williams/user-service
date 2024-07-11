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
    public UserModel getUser(Long id) {
        return UserMapper.mapFrom(userRepository.findById(id).orElseThrow(() ->
                        new NotFoundException("User not found with id: " + id)
                )
        );
    }
}
