package com.example.todolistbackend.service;


import com.example.todolistbackend.dto.impl.UserDtoImpl;
import com.example.todolistbackend.secure.JWTAuthResponse;
import com.example.todolistbackend.secure.SignIn;

public interface AuthService {
    JWTAuthResponse signUp(UserDtoImpl userDto);
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse refreshToken(String existingToken);
}
