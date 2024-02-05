package org.soa.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "shop")
@Getter
@Setter
public class Shop {
    @Id
    @Basic(optional = false)
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long shopId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "owner", nullable = false)
    private String owner;

    @OneToMany(mappedBy = "shop")
    private Set<FlowerStock> flowerStocks = new LinkedHashSet<>();
}