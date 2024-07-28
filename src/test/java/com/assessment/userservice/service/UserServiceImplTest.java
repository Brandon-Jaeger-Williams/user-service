package com.assessment.userservice.service;

import com.assessment.userservice.core.exception.NotFoundException;
import com.assessment.userservice.entity.UserEntity;
import com.assessment.userservice.model.UserModel;
import com.assessment.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    private UserService userService;

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void test_getUser_with_valid_user_should_return_user() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test");
        userEntity.setPassword("123");

        when(userRepository.findByUsername(any())).thenReturn(Optional.of(userEntity));

        UserModel user = userService.getUser("test");
        assertNotNull(user);
        assertEquals("test", user.getUsername());
    }

    @Test
    void test_getUser_with_in_valid_user_should_throw_an_exception() {
        when(userRepository.findByUsername(any())).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundException.class, () -> userService.getUser("test"));

        assertEquals("User not found with username: test", exception.getMessage());
    }
}