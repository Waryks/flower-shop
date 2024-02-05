package org.soa.service;

import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.soa.dto.FlowerDto;
import org.soa.dto.FlowerMapper;
import org.soa.entity.Flower;
import org.soa.exception.UserNotFoundException;
import org.soa.repository.FlowerRepository;

@ApplicationScoped
public class FlowerService {
    @Inject
    FlowerRepository flowerRepository;
    @Inject
    FlowerMapper flowerMapper;

    @Inject
    @Channel("flower-shop-kafka")
    Emitter<String> emitter;

    public FlowerDto getFlowerDetails(Long flowerId){
        Flower flower = flowerRepository.findByIdOptional(flowerId).orElseThrow(()
                -> new UserNotFoundException("Flower does not exist"));
        emitter.send("Flower class with id: " + flowerId + " was fetched sucessfuly");
        return flowerMapper.toDto(flower);
    }

    @Transactional
    public Long createFlower(FlowerDto flowerDto) {
        Flower flower = flowerMapper.toEntity(flowerDto);
        flowerRepository.persist(flower);
        return flower.getFlowerId();
    }
    @Transactional
    public void changeFlowerDetails(Long flowerId, FlowerDto flowerDto) {
        Flower flower = flowerRepository.findByIdOptional(flowerId).orElseThrow(()
                -> new UserNotFoundException("Flower does not exist"));
        if(flowerDto.getDescription() != null)
            flower.setDescription(flowerDto.getDescription());
        if(flowerDto.getName() != null)
            flower.setName(flowerDto.getName());
        if(flowerDto.getPrice() != null)
            flower.setPrice(flowerDto.getPrice());
        if(flowerDto.getAvailabilityStatus() != null)
            flower.setAvailabilityStatus(flowerDto.getAvailabilityStatus());
        flowerRepository.persist(flower);
    }

    @Transactional
    public void deleteFlower(Long flowerId) {
        flowerRepository.findByIdOptional(flowerId).orElseThrow(()
                -> new UserNotFoundException("Flower does not exist"));
        flowerRepository.deleteById(flowerId);
    }
}
