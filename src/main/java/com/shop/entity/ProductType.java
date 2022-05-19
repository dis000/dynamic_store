package com.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Тип продукта
 */
@Entity
@Table
@Getter
@Setter
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String nameCategory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productType")
    private Set<Product> products;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productType")
    @JsonIgnore
    private Set<ProductFeature> productFeatures;


    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
