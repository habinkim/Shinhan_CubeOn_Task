package com.habin.shinhan_cubeon_task.user.mapper;

import com.habin.shinhan_cubeon_task.common.mapper.EntityMapper;
import com.habin.shinhan_cubeon_task.user.dto.SignUpRequestDto;
import com.habin.shinhan_cubeon_task.user.entity.User;
import org.mapstruct.*;

@Mapper(
		componentModel = "spring",
		uses = {EntityMapper.class},
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {

    User toEntity(SignUpRequestDto signUpRequestDto);

}
