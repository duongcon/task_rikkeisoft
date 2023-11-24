package com.example.task.controller;

import com.example.task.domain.dto.TaskDTO;
import com.example.task.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class TaskController {
    private final Logger log = LogManager.getLogger(TaskController.class);
    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<TaskDTO> create(@RequestBody @Valid TaskDTO taskDTO) {
        log.info("===== create task ====== ");
        return new ResponseEntity<>(taskService.create(taskDTO), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable("id") Long id, @RequestBody @Valid TaskDTO taskDTO) {
        log.info("===== update task ====== ");
        return new ResponseEntity<>(taskService.update(id, taskDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        log.info("===== delete task ====== ");
        return new ResponseEntity<>(taskService.delete(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<TaskDTO>> findAll(@Valid Pageable pageable) {
        log.info("===== find all task ====== ");
        return new ResponseEntity<>(taskService.findAll(pageable), HttpStatus.OK);
    }
}
