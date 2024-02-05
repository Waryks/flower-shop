package org.soa.dto;

import jakarta.enterprise.context.ApplicationScoped;
import javax.annotation.processing.Generated;
import org.soa.entity.Shop;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T00:52:03+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class ShopMapperImpl implements ShopMapper {

    @Override
    public ShopDto toDto(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDto shopDto = new ShopDto();

        shopDto.setShopId( shop.getShopId() );
        shopDto.setName( shop.getName() );
        shopDto.setLocation( shop.getLocation() );
        shopDto.setOwner( shop.getOwner() );

        return shopDto;
    }

    @Override
    public Shop toEntity(ShopDto shopDto) {
        if ( shopDto == null ) {
            return null;
        }

        Shop shop = new Shop();

        shop.setShopId( shopDto.getShopId() );
        shop.setName( shopDto.getName() );
        shop.setLocation( shopDto.getLocation() );
        shop.setOwner( shopDto.getOwner() );

        return shop;
    }
}
