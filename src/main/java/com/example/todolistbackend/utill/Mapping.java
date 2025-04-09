package com.example.todolistbackend.utill;

import com.example.todolistbackend.dto.impl.TaskDtoImpl;
import com.example.todolistbackend.entity.impl.TaskEntity;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public TaskEntity toTaskEntity(TaskDtoImpl taskDto) {
        return modelMapper.map(taskDto, TaskEntity.class);
    }
    public TaskDtoImpl toTaskDto(TaskEntity taskEntity) {
        return modelMapper.map(taskEntity, TaskDtoImpl.class);
    }
    public List<TaskDtoImpl> toTaskDtoList(List<TaskEntity> taskEntityList) {
        return modelMapper.map(taskEntityList, new TypeToken<List<TaskDtoImpl>>() {}.getType());
    }
}
