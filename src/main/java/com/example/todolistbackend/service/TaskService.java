package com.example.todolistbackend.service;

import com.example.todolistbackend.dto.impl.TaskDtoImpl;

import java.util.List;

public interface TaskService {
    void saveTask(TaskDtoImpl taskDto);
    List<TaskDtoImpl> getAllTasks();
}
