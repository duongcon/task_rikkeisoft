package com.example.task.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TaskDTOTest {

    private TaskDTO taskDTOUnderTest;

    @BeforeEach
    void setUp() {
        taskDTOUnderTest = new TaskDTO(0L, "taskName", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0, 0), 0);
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        taskDTOUnderTest.setId(id);
        assertThat(taskDTOUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testTaskNameGetterAndSetter() {
        final String taskName = "taskName";
        taskDTOUnderTest.setTaskName(taskName);
        assertThat(taskDTOUnderTest.getTaskName()).isEqualTo(taskName);
    }

    @Test
    void testStartingDateGetterAndSetter() {
        final LocalDateTime startingDate = LocalDateTime.of(2020, 1, 1, 0, 0, 0);
        taskDTOUnderTest.setStartingDate(startingDate);
        assertThat(taskDTOUnderTest.getStartingDate()).isEqualTo(startingDate);
    }

    @Test
    void testEndingDateGetterAndSetter() {
        final LocalDateTime endingDate = LocalDateTime.of(2020, 1, 1, 0, 0, 0);
        taskDTOUnderTest.setEndingDate(endingDate);
        assertThat(taskDTOUnderTest.getEndingDate()).isEqualTo(endingDate);
    }

    @Test
    void testStatusGetterAndSetter() {
        final Integer status = 0;
        taskDTOUnderTest.setStatus(status);
        assertThat(taskDTOUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testEquals() {
        assertThat(taskDTOUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(taskDTOUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(taskDTOUnderTest.hashCode()).isNotEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(taskDTOUnderTest.toString()).isNotEqualTo("result");
    }

    @Test
    void testBuilder() {
        final TaskDTO.TaskDTOBuilder result = TaskDTO.builder();
    }
}
