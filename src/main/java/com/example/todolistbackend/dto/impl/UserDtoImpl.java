package com.example.todolistbackend.dto.impl;

import com.example.todolistbackend.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDtoImpl implements UserStatus {
    private String email;
    private String password;
    private String name;
}
