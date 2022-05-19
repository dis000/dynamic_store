package com.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Конкретная характеристика
 */
@Getter
@Setter
@Entity
@Table
public class ValueProductFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    private String value;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    @JsonIgnore
    private Product product;
    //id


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_FEATURE_ID")
    private ProductFeature productFeature;
    //id

    @Override
    public String toString() {
        return "ValueProductFeature{" +
                "value='" + value + '\'' +
                ", productFeature=" + productFeature +
                '}';
    }
}
