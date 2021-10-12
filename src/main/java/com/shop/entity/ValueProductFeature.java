package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class ValueProductFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;



    private String value;



    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;


    @ManyToOne(fetch = FetchType.EAGER)
    private ProductFeature productFeature;


}
