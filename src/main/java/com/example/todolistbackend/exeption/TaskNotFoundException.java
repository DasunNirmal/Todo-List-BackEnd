package com.example.todolistbackend.exeption;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {
    }

    public TaskNotFoundException(String message) {
    }

    public TaskNotFoundException(String message, Throwable cause) {
    }
}
