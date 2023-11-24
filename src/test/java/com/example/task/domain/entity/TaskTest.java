package com.example.task.domain.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {

    private Task taskUnderTest;

    @BeforeEach
    void setUp() {
        taskUnderTest = new Task(0L, "taskName", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0, 0), 0);
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        taskUnderTest.setId(id);
        assertThat(taskUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testTaskNameGetterAndSetter() {
        final String taskName = "taskName";
        taskUnderTest.setTaskName(taskName);
        assertThat(taskUnderTest.getTaskName()).isEqualTo(taskName);
    }

    @Test
    void testStartingDateGetterAndSetter() {
        final LocalDateTime startingDate = LocalDateTime.of(2020, 1, 1, 0, 0, 0);
        taskUnderTest.setStartingDate(startingDate);
        assertThat(taskUnderTest.getStartingDate()).isEqualTo(startingDate);
    }

    @Test
    void testEndingDateGetterAndSetter() {
        final LocalDateTime endingDate = LocalDateTime.of(2020, 1, 1, 0, 0, 0);
        taskUnderTest.setEndingDate(endingDate);
        assertThat(taskUnderTest.getEndingDate()).isEqualTo(endingDate);
    }

    @Test
    void testStatusGetterAndSetter() {
        final Integer status = 0;
        taskUnderTest.setStatus(status);
        assertThat(taskUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testEquals() {
        assertThat(taskUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(taskUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(taskUnderTest.hashCode()).isNotEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(taskUnderTest.toString()).isNotEqualTo("result");
    }

    @Test
    void testBuilder() {
        final Task.TaskBuilder result = Task.builder();
    }
}
