package com.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


/**
 * Характеристика продукта
 */
@Entity
@Setter
@Getter
@Table

public class ProductFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productFeature")
    @JsonIgnore
    private Set<ValueProductFeature> valueProductFeature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    @JsonIgnore
    private ProductType productType;


}
