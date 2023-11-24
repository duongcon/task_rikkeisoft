package com.example.task.repository;

import com.example.task.domain.dto.TaskDTO;
import com.example.task.domain.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select new com.example.task.domain.dto.TaskDTO(t.id, t.taskName, t.startingDate, t.endingDate, t.status) from Task t ")
    Page<TaskDTO> getTaskAll(Pageable pageable);
}
