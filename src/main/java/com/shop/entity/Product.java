package com.shop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Продукт
 */
@Entity
@Setter
@Getter
@Table
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    @JsonIgnore
    private ProductType productType;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    @JsonIgnore
    private Set<ValueProductFeature> valueProductFeature;

}