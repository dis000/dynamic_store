package com.shop.entity;

import javax.persistence.*;

@Entity
@Table
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;




}
