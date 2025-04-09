package com.example.todolistbackend.service.impl;

import com.example.todolistbackend.dao.TaskDao;
import com.example.todolistbackend.dto.impl.TaskDtoImpl;
import com.example.todolistbackend.entity.impl.TaskEntity;
import com.example.todolistbackend.exeption.DataPersistException;
import com.example.todolistbackend.service.TaskService;
import com.example.todolistbackend.utill.AppUtil;
import com.example.todolistbackend.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
