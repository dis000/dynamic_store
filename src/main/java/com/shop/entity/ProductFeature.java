package com.shop.entity;

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
@ToString
public class ProductFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productFeature")
    private Set<ValueProductFeature> valueProductFeature;

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProductType productType;



}
