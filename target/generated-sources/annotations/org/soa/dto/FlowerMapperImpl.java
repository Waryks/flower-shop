package org.soa.dto;

import jakarta.enterprise.context.ApplicationScoped;
import javax.annotation.processing.Generated;
import org.soa.entity.Flower;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T00:52:03+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class FlowerMapperImpl implements FlowerMapper {

    @Override
    public FlowerDto toDto(Flower flower) {
        if ( flower == null ) {
            return null;
        }

        FlowerDto flowerDto = new FlowerDto();

        flowerDto.setFlowerId( flower.getFlowerId() );
        flowerDto.setName( flower.getName() );
        flowerDto.setDescription( flower.getDescription() );
        flowerDto.setPrice( flower.getPrice() );
        flowerDto.setAvailabilityStatus( flower.getAvailabilityStatus() );

        return flowerDto;
    }

    @Override
    public Flower toEntity(FlowerDto flowerDto) {
        if ( flowerDto == null ) {
            return null;
        }

        Flower flower = new Flower();

        flower.setFlowerId( flowerDto.getFlowerId() );
        flower.setName( flowerDto.getName() );
        flower.setDescription( flowerDto.getDescription() );
        flower.setPrice( flowerDto.getPrice() );
        flower.setAvailabilityStatus( flowerDto.getAvailabilityStatus() );

        return flower;
    }
}
