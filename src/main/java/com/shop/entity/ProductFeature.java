package com.shop.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class ProductFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<ValueCharacteristic> valueCharacteristic;

    @Column("name")
    @NotNull
    private String name;
}
