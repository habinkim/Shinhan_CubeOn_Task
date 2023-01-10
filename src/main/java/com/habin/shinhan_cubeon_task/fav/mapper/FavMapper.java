package com.habin.shinhan_cubeon_task.fav.mapper;

import com.habin.shinhan_cubeon_task.common.mapper.EntityMapper;
import com.habin.shinhan_cubeon_task.fav.entity.Fav;
import org.mapstruct.*;

@Mapper(
		componentModel = "spring",
		uses = {EntityMapper.class},
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FavMapper {

	@Mapping(target = "favId", ignore = true)
	@Mapping(target = "user", source = "userId")
    @Mapping(target = "review", source = "reviewId")
    Fav toEntity(String userId, Long reviewId);

}
