package com.example.task.service.impl;

import com.example.task.domain.dto.TaskDTO;
import com.example.task.domain.entity.Task;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    @Transactional(rollbackOn = {Exception.class})
    public TaskDTO create(TaskDTO taskDTO) {
        Task task = Task.builder()
                .taskName(taskDTO.getTaskName())
                .startingDate(taskDTO.getStartingDate())
                .endingDate(taskDTO.getEndingDate())
                .status(taskDTO.getStatus())
                .build();
        task = taskRepository.save(task);
        taskDTO.setId(task.getId());
        return taskDTO;
    }

    @Override
    @Transactional(rollbackOn = {Exception.class})
    public TaskDTO update(Long id, TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new RuntimeException("task-not-found");
        }
        Task task = optionalTask.get();
        task.setTaskName(taskDTO.getTaskName());
        task.setStartingDate(taskDTO.getStartingDate());
        task.setEndingDate(taskDTO.getEndingDate());
        task.setStatus(taskDTO.getStatus());
        task = taskRepository.save(task);
        taskDTO.setId(task.getId());
        return taskDTO;
    }

    @Override
    @Transactional(rollbackOn = {Exception.class})
    public Long delete(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new RuntimeException("task-not-found");
        }
        taskRepository.delete(optionalTask.get());
        return id;
    }

    @Override
    public Page<TaskDTO> findAll(Pageable pageable) {
        return taskRepository.getTaskAll(pageable);
    }
}
