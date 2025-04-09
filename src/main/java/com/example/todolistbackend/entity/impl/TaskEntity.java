package com.example.todolistbackend.entity.impl;

import com.example.todolistbackend.entity.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class TaskEntity implements SuperEntity {
    @Id
    private String id;
    private String description;
    private String status;
    private String createdAt;
}
