package com.assessment.userservice.controller;

import com.assessment.userservice.model.UserModel;
import com.assessment.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @PreAuthorize("authentication.principal.id.equals(#id)")
    public UserModel getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
