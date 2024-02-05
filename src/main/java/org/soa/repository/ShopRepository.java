package org.soa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.soa.entity.Shop;

@ApplicationScoped
public class ShopRepository implements PanacheRepository<Shop> {
}
