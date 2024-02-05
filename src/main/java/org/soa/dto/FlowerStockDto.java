package org.soa.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.soa.entity.FlowerStock}
 */
@Getter
@Setter
public class FlowerStockDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long stockId;
    private ShopDto shop;
    private FlowerDto flower;
    private Integer quantity;
}