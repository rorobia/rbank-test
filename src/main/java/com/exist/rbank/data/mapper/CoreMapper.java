package com.exist.rbank.data.mapper;

import com.exist.rbank.data.dto.SubTaskDto;
import com.exist.rbank.data.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CoreMapper {

    @Mapping(target = "subTasks", ignore = true)
    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "endDate", ignore = true)
    TaskDto toDto(TaskDto dto);

    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "endDate", ignore = true)
    SubTaskDto toDto(SubTaskDto dto);
}
