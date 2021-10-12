package com.shop.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table
public class ProductFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productFeature")
    private Set<ValueProductCharacteristic> valueProductCharacteristic;

    @Column(name = "name")
    @NotNull
    private String name;




}
