package com.exist.rbank.service.impl;

import com.exist.rbank.data.dto.SubTaskDto;
import com.exist.rbank.data.dto.TaskDto;
import com.exist.rbank.data.exception.InvalidDataException;
import com.exist.rbank.data.mapper.CoreMapper;
import com.exist.rbank.service.CalendarScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarScheduleServiceImpl implements CalendarScheduleService {

    @Autowired
    private CoreMapper mapper;

    @Override
    public List<TaskDto> getCalendarSchedule(List<TaskDto> taskDtos) throws InvalidDataException {
        List<TaskDto> taskDtoList = new ArrayList<>();

        for (TaskDto taskDto : taskDtos) {
            if (taskDto.getDuration() == null) {
                throw new InvalidDataException("Task Duration cannot be empty");
            }

            List<SubTaskDto> subTaskDtos = new ArrayList<>();

            LocalDate startDate = LocalDate.now();

            if (taskDto.getSubTasks() != null) {
                for (SubTaskDto subTaskDto: taskDto.getSubTasks()) {
                    if (subTaskDto.getDuration() == null) {
                        throw new InvalidDataException("Sub-task Duration cannot be empty");
                    }

                    SubTaskDto subTask = mapper.toDto(subTaskDto);
                    subTask.setStartDate(startDate);
                    subTask.setEndDate(startDate.plusDays(subTaskDto.getDuration()));
                    subTaskDtos.add(subTask);

                    startDate = subTask.getEndDate().plusDays(1L);
                }

            }

            TaskDto task = mapper.toDto(taskDto);
            task.setStartDate(startDate);
            task.setEndDate(startDate.plusDays(taskDto.getDuration()));
            task.setSubTasks(subTaskDtos);

            taskDtoList.add(task);
        }

        return taskDtoList;
    }
}
