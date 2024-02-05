package org.soa.dto;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.soa.entity.Flower;
import org.soa.entity.Shop;

@Mapper(componentModel = "jakarta-cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR
        , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ShopMapper {
    @Mapping(source = "shopId", target = "shopId")
    ShopDto toDto(Shop shop);

    @Mapping(source = "shopId", target = "shopId")
    Shop toEntity(ShopDto shopDto);
}
