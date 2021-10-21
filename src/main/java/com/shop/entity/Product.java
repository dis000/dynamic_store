package com.shop.entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Продукт
 */
@Entity
@Setter
@Getter
@Table
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
    private Integer price;


    @NotNull
    @ManyToOne
    private Product productCategory;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private Set<ValueProductFeature> valueProductFeature;
}
