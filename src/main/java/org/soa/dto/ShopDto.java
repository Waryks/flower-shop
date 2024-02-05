package org.soa.dto;

import lombok.Getter;
import lombok.Setter;
import org.soa.entity.Shop;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Shop}
 */
@Getter
@Setter
public class ShopDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long shopId;
    private String name;
    private String location;
    private String owner;
}