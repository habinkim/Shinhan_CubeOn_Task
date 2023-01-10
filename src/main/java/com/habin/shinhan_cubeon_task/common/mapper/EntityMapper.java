package com.habin.shinhan_cubeon_task.common.mapper;

import com.habin.shinhan_cubeon_task.review.entity.Lecture;
import com.habin.shinhan_cubeon_task.user.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
		uses = {ReferenceMapper.class},
		builder = @Builder(disableBuilder = true),
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EntityMapper {

	User stringToUser(String userId);

	Lecture integerToLecture(Integer lectureId);

}
