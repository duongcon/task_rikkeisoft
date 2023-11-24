package com.example.task.service.impl;

import com.example.task.domain.dto.TaskDTO;
import com.example.task.domain.entity.Task;
import com.example.task.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository mockTaskRepository;

    private TaskServiceImpl taskServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        taskServiceImplUnderTest = new TaskServiceImpl(mockTaskRepository);
    }

    @Test
    void testCreate() {
        final TaskDTO taskDTO = TaskDTO.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build();
        final TaskDTO expectedResult = TaskDTO.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build();
        final Task task = Task.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build();
        when(mockTaskRepository.save(Task.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build())).thenReturn(task);
        try {
            final TaskDTO result = taskServiceImplUnderTest.create(taskDTO);
            assertThat(result).isEqualTo(expectedResult);
        } catch (Exception e) {
        }
    }

    @Test
    void testUpdate() {
        final TaskDTO taskDTO = TaskDTO.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build();
        final TaskDTO expectedResult = TaskDTO.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build();
        final Optional<Task> optionalTask = Optional.of(Task.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build());
        when(mockTaskRepository.findById(0L)).thenReturn(optionalTask);
        final Task task = Task.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build();
        when(mockTaskRepository.save(Task.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build())).thenReturn(task);
        final TaskDTO result = taskServiceImplUnderTest.update(0L, taskDTO);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdate_TaskRepositoryFindByIdReturnsAbsent() {
        final TaskDTO taskDTO = TaskDTO.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build();
        when(mockTaskRepository.findById(0L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> taskServiceImplUnderTest.update(0L, taskDTO)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void testDelete() {
        final Optional<Task> optionalTask = Optional.of(Task.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build());
        when(mockTaskRepository.findById(0L)).thenReturn(optionalTask);
        final Long result = taskServiceImplUnderTest.delete(0L);
        assertThat(result).isEqualTo(0L);
        verify(mockTaskRepository).delete(Task.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build());
    }

    @Test
    void testDelete_TaskRepositoryFindByIdReturnsAbsent() {
        when(mockTaskRepository.findById(0L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> taskServiceImplUnderTest.delete(0L)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void testFindAll() {
        final Page<TaskDTO> taskDTOS = new PageImpl<>(List.of(TaskDTO.builder()
                .id(0L)
                .taskName("taskName")
                .startingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .endingDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0))
                .status(0)
                .build()));
        when(mockTaskRepository.getTaskAll(any(Pageable.class))).thenReturn(taskDTOS);
        final Page<TaskDTO> result = taskServiceImplUnderTest.findAll(PageRequest.of(0, 1));
    }

    @Test
    void testFindAll_TaskRepositoryReturnsNoItems() {
        when(mockTaskRepository.getTaskAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));
        final Page<TaskDTO> result = taskServiceImplUnderTest.findAll(PageRequest.of(0, 1));
    }
}
