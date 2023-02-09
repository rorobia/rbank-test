package com.exist.rbank.data.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SubTaskDto {

    private String name;

    private Long duration;

    private LocalDate startDate;

    private LocalDate endDate;

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
