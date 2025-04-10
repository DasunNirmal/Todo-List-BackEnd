package com.example.todolistbackend.service.impl;

import com.example.todolistbackend.dao.TaskDao;
import com.example.todolistbackend.dto.impl.TaskDtoImpl;
import com.example.todolistbackend.entity.impl.TaskEntity;
import com.example.todolistbackend.exeption.DataPersistException;
import com.example.todolistbackend.exeption.TaskNotFoundException;
import com.example.todolistbackend.service.TaskService;
import com.example.todolistbackend.utill.AppUtil;
import com.example.todolistbackend.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveTask(TaskDtoImpl taskDto) {
        taskDto.setId(AppUtil.generateTaskId());
        TaskEntity save = taskDao.save(mapping.toTaskEntity(taskDto));
        if (save == null) {
            throw new DataPersistException("Task not saved");
        }
    }

    @Override
    public List<TaskDtoImpl> getAllTasks() {
        return mapping.toTaskDtoList(taskDao.findAll());
    }

    @Override
    public void updateTask(String id, TaskDtoImpl taskDto) {
        Optional<TaskEntity> task = taskDao.findById(id);
        if (task.isPresent()) {
            TaskEntity taskEntity = task.get();
            System.out.println("Task found: " + task.get());
            task.get().setDescription(taskDto.getDescription());
            task.get().setStatus(taskDto.getStatus());
            task.get().setCreated_at(taskDto.getCreated_at());
            taskDao.save(taskEntity);
        } else {
            throw new TaskNotFoundException("Task not found");
        }
    }

    @Override
    public void deleteTask(String id) {
        Optional<TaskEntity> task = taskDao.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Task not found");
        }
        taskDao.deleteById(id);
    }
}
