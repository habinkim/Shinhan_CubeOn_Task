package com.habin.shinhan_cubeon_task.review.mapper;

import com.habin.shinhan_cubeon_task.common.mapper.EntityMapper;
import com.habin.shinhan_cubeon_task.review.dto.ReviewCreateDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewUpdateDto;
import com.habin.shinhan_cubeon_task.review.entity.Review;
import org.mapstruct.*;

@Mapper(
		componentModel = "spring",
		uses = {EntityMapper.class},
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ReviewMapper {

	@Mapping(target = "reviewId", ignore = true)
	@Mapping(target = "favCount", constant = "0")
	@Mapping(target = "lecture", constant = "1")
	@Mapping(target = "user", source = "userId")
	@Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
	@Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
	Review createDtoToEntity(ReviewCreateDto reviewCreateDto);

	@Mapping(target = "favCount", ignore = true)
	@Mapping(target = "user", ignore = true)
	@Mapping(target = "lecture", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	Review.ReviewBuilder updateDtoToEntity(ReviewUpdateDto reviewUpdateDto, @MappingTarget Review.ReviewBuilder review);
}
