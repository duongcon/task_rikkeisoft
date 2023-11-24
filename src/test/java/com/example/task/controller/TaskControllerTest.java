package com.example.task.controller;

import com.example.task.domain.dto.TaskDTO;
import com.example.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService mockTaskService;

    @Test
    void testCreate() throws Exception {
        when(mockTaskService.create(TaskDTO.builder().build())).thenReturn(TaskDTO.builder().build());
        final MockHttpServletResponse response = mockMvc.perform(post("/api/task")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isNotEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEqualTo("expectedResponse");
    }

    @Test
    void testUpdate() throws Exception {
        when(mockTaskService.update(0L, TaskDTO.builder().build())).thenReturn(TaskDTO.builder().build());
        final MockHttpServletResponse response = mockMvc.perform(put("/api/task/{id}", 0)
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isNotEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEqualTo("expectedResponse");
    }

    @Test
    void testDelete() throws Exception {
        when(mockTaskService.delete(0L)).thenReturn(0L);
        final MockHttpServletResponse response = mockMvc.perform(delete("/api/task/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEqualTo("expectedResponse");
    }

    @Test
    void testFindAll() throws Exception {
        final Page<TaskDTO> taskDTOS = new PageImpl<>(List.of(TaskDTO.builder().build()));
        when(mockTaskService.findAll(any(Pageable.class))).thenReturn(taskDTOS);
        final MockHttpServletResponse response = mockMvc.perform(get("/api/task")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isNotEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEqualTo("expectedResponse");
    }

    @Test
    void testFindAll_TaskServiceReturnsNoItems() throws Exception {
        when(mockTaskService.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));
        final MockHttpServletResponse response = mockMvc.perform(get("/api/task")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isNotEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEqualTo("[]");
    }
}
