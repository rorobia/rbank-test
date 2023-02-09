package com.exist.rbank.resource;

import com.exist.rbank.data.dto.TaskDto;
import com.exist.rbank.data.exception.InvalidDataException;
import com.exist.rbank.service.CalendarScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calendar-schedule")
public class CalendarScheduleResource {

    @Autowired
    private CalendarScheduleService calendarScheduleService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> get(@RequestBody List<TaskDto> taskDtos) throws InvalidDataException {
        return new ResponseEntity<>(calendarScheduleService.getCalendarSchedule(taskDtos), HttpStatus.OK);
    }
}
