package com.example.todolistbackend.service;

import com.example.todolistbackend.dto.impl.TaskDtoImpl;

import java.util.List;

public interface TaskService {
    void saveTask(TaskDtoImpl taskDto);
    List<TaskDtoImpl> getAllTasks();
    void updateTask(String id, TaskDtoImpl taskDto);
    void deleteTask(String id);
}
