package com.example.todolistbackend.controller;

import com.example.todolistbackend.dto.impl.TaskDtoImpl;
import com.example.todolistbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveTasks(@RequestBody TaskDtoImpl taskDto) {
        try {
            taskService.saveTask(taskDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDtoImpl> getAllTasks() { return taskService.getAllTasks(); }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable("id") String id, @RequestBody TaskDtoImpl taskDto) {
        try {
            taskService.updateTask(id, taskDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
