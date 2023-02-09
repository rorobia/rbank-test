package com.exist.rbank.data.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TaskDto {

    private Long duration;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<SubTaskDto> subTasks;
}
