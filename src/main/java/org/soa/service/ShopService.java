package org.soa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.soa.dto.ShopDto;
import org.soa.dto.ShopMapper;
import org.soa.entity.Shop;
import org.soa.exception.UserNotFoundException;
import org.soa.repository.ShopRepository;

@ApplicationScoped
public class ShopService {
    @Inject
    ShopRepository shopRepository;
    @Inject
    ShopMapper shopMapper;
    public ShopDto getShop(Long shopId) {
        Shop shop = shopRepository.findByIdOptional(shopId).orElseThrow(()
                -> new UserNotFoundException("Shop does not exist"));
        return shopMapper.toDto(shop);
    }

    @Transactional
    public Long createShop(ShopDto shopDto) {
        Shop shop = shopMapper.toEntity(shopDto);
        shopRepository.persist(shop);
        return shop.getShopId();
    }
}
