package org.soa.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "flower_stock")
@Getter
@Setter
public class FlowerStock {
    @Id
    @Basic(optional = false)
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long stockId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flower_id")
    private Flower flower;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}