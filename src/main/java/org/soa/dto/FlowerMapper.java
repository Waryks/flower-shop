package org.soa.dto;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.soa.entity.Flower;

@Mapper(componentModel = "jakarta-cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR
        , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FlowerMapper {

    @Mapping(source = "flowerId", target = "flowerId")
    FlowerDto toDto(Flower flower);

    @Mapping(source = "flowerId", target = "flowerId")
    Flower toEntity(FlowerDto flowerDto);
}
