package com.assessment.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends AuditEntity {

    @Column(name = "username")
    @Size(max = 50, message = "The maximum length of username is 50")
    private String username;

    @Column(name = "password")
    @Size(max = 255, message = "The maximum length of password is 255")
    private String password;
}
