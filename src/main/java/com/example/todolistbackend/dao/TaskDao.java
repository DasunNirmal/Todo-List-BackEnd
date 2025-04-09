package com.example.todolistbackend.dao;

import com.example.todolistbackend.entity.impl.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<TaskEntity, String> {
}
