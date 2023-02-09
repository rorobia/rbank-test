package com.exist.rbank.data.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SubTaskDto {

    private String name;

    private Long duration;

    private LocalDate startDate;

    private LocalDate endDate;

}
