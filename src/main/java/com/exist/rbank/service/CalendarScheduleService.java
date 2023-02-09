package com.exist.rbank.service;

import com.exist.rbank.data.dto.TaskDto;
import com.exist.rbank.data.exception.InvalidDataException;

import java.util.List;

public interface CalendarScheduleService {

    List<TaskDto> getCalendarSchedule(List<TaskDto> taskDtos) throws InvalidDataException;
}
