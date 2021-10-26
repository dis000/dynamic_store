package com.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Конкретная характеристика
 */
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
    @JoinColumn(name = "PRODUCT_ID")
    @JsonIgnore
    private Product product;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_FEATURE_ID")
    private ProductFeature productFeature;


}
