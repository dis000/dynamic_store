package com.shop.entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("id")
    private Long id;

    @Column("name")
    @NonNull
    private String name;

    @Column("price")
    @NotNull
    private Integer price;

    @Column("type")
    @NotNull
    private String type;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<ValueCharacteristic> valueCharacteristic;
}
