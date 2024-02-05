package org.soa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.soa.entity.Flower;

@ApplicationScoped
public class FlowerRepository implements PanacheRepository<Flower> {
}
