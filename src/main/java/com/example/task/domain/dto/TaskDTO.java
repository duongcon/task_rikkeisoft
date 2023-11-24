package com.example.task.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private Long id;
    private String taskName;
    private LocalDateTime startingDate;
    private LocalDateTime endingDate;
    @Min(0)
    @Max(2)
    @NotNull
    private Integer status;
}
