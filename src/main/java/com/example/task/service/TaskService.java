package com.example.task.service;

import com.example.task.domain.dto.TaskDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskDTO create(TaskDTO taskDTO);
    TaskDTO update(Long id, TaskDTO taskDTO);
    Long delete(Long id);
    Page<TaskDTO> findAll(Pageable pageable);
}
