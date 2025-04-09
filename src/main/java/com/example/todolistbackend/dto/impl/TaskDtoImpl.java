package com.example.todolistbackend.dto.impl;

import com.example.todolistbackend.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDtoImpl implements TaskStatus {
    private int id;
    private String title;
    private String description;
    private String status;
    private String createdAt;
}
