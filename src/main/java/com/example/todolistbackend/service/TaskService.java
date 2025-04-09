package com.example.todolistbackend.service;

import com.example.todolistbackend.dto.impl.TaskDtoImpl;

public interface TaskService {
    void saveTask(TaskDtoImpl taskDto);
}
