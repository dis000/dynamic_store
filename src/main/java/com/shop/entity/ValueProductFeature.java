package com.shop.entity;

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
    private Product product;


    @ManyToOne(fetch = FetchType.EAGER)
    private ProductFeature productFeature;

    @Override
    public String toString() {
        return "ValueProductFeature{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
