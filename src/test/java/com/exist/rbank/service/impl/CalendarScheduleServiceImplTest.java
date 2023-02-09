package com.exist.rbank.service.impl;

import com.exist.rbank.data.dto.SubTaskDto;
import com.exist.rbank.data.dto.TaskDto;
import com.exist.rbank.data.exception.InvalidDataException;
import com.exist.rbank.service.CalendarScheduleService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalendarScheduleServiceImplTest {

    @Autowired
    private CalendarScheduleService calendarScheduleService;

    @Test
    public void testGetCalendarSchedule() throws InvalidDataException {
        TaskDto taskDto = new TaskDto();
        taskDto.setName("House Renovation");
        taskDto.setDuration(10L);

        SubTaskDto subTaskDto1 = new SubTaskDto();
        subTaskDto1.setName("Wall Renovation");
        subTaskDto1.setDuration(2L);

        SubTaskDto subTaskDto2 = new SubTaskDto();
        subTaskDto2.setName("Repainting");
        subTaskDto2.setDuration(3L);

        taskDto.setSubTasks(Lists.newArrayList(subTaskDto1, subTaskDto2));

        List<TaskDto> result = calendarScheduleService.getCalendarSchedule(Lists.newArrayList(taskDto));

        assertNotNull(result);
        assertEquals(1, result.size());

        assertEquals(taskDto.getName(), result.get(0).getName());
        assertEquals(LocalDate.now().plusDays(7L), result.get(0).getStartDate());
        assertEquals(LocalDate.now().plusDays(17L), result.get(0).getEndDate());

        assertEquals(2, result.get(0).getSubTasks().size());

        assertEquals(subTaskDto1.getName(), result.get(0).getSubTasks().get(0).getName());
        assertEquals(LocalDate.now(), result.get(0).getSubTasks().get(0).getStartDate());
        assertEquals(LocalDate.now().plusDays(2L), result.get(0).getSubTasks().get(0).getEndDate());

        assertEquals(subTaskDto2.getName(), result.get(0).getSubTasks().get(1).getName());
        assertEquals(LocalDate.now().plusDays(3L), result.get(0).getSubTasks().get(1).getStartDate());
        assertEquals(LocalDate.now().plusDays(6L), result.get(0).getSubTasks().get(1).getEndDate());

    }
}
