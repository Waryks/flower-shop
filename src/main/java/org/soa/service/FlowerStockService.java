package org.soa.service;

import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.soa.entity.Flower;
import org.soa.entity.FlowerStock;
import org.soa.exception.UserNotFoundException;
import org.soa.repository.FlowerRepository;
import org.soa.repository.FlowerStockRepository;

import java.util.List;

@ApplicationScoped
public class FlowerStockService {
    @Inject
    FlowerStockRepository flowerStockRepository;

    @Channel("flower-shop")
    Emitter<JsonObject> emitter;

    @Transactional
    public Integer checkoutFromStock(Long flowerId, Integer quantity){
        List<FlowerStock> flowerStockList = flowerStockRepository.findByFlower(flowerId);
        for(FlowerStock flowerStock : flowerStockList){
            if(flowerStock.getQuantity() >= quantity){
                flowerStock.setQuantity(flowerStock.getQuantity()-quantity);
                flowerStockRepository.persist(flowerStock);
                JsonObject obj = new JsonObject();
                obj.put("status", "ok");
                obj.put("description", "quantity was changed sucesfully for the flower "+flowerId+" to "+ flowerStock.getQuantity());
                emitter.send(obj);
                return flowerStock.getQuantity();
            }
        }
        throw new UserNotFoundException(flowerId.toString());
    }
}
