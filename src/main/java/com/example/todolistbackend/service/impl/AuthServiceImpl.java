package com.example.todolistbackend.service.impl;

import com.example.todolistbackend.dao.UserDao;
import com.example.todolistbackend.dto.impl.UserDtoImpl;
import com.example.todolistbackend.entity.impl.UserEntity;
import com.example.todolistbackend.exeption.UserNotFoundException;
import com.example.todolistbackend.secure.JWTAuthResponse;
import com.example.todolistbackend.secure.SignIn;
import com.example.todolistbackend.service.AuthService;
import com.example.todolistbackend.service.JWTService;
import com.example.todolistbackend.utill.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserDao userDao;
    private final JWTService jwtService;
    private final Mapping mapping;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signUp(UserDtoImpl userDto) {
        userDto.setPassword(userDto.getPassword());
        UserEntity userEntity = mapping.toUserEntity(userDto);
        if (userDao.existsById(userDto.getEmail())) throw new UserNotFoundException("User Already Exists");
        userDao.save(userEntity);
        var jwtToken = jwtService.generateJwtToken(userEntity);
        return JWTAuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userEntity = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        var jwtToken = jwtService.generateJwtToken(userEntity);
        return JWTAuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.getUserEmail(accessToken);
        var findUser = userDao.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        var jwtToken = jwtService.generateJwtToken(findUser);
        return JWTAuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
