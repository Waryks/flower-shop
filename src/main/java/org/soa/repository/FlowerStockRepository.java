package org.soa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.soa.entity.FlowerStock;

import java.util.List;

@ApplicationScoped
public class FlowerStockRepository implements PanacheRepository<FlowerStock> {
    public List<FlowerStock> findByFlower(Long flowerId){
        return find("flower.flowerId", flowerId).stream().toList();
    }
}
