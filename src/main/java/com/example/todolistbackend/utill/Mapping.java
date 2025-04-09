package com.example.todolistbackend.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
}
