package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

//@Entity
//@Table(name = "products")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer Id;
//    private Integer authorId;
//    private Integer categoryId;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_name")
    private String productDescription;
    private String productImage;
    private BigDecimal productPrice;
    private String productType;
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn (name = "categoryId")
    private Category Category;

    @ManyToOne
    @JoinColumn (name = "authorId")
    private Author Author;

    @OneToMany
    @JoinColumn (name = "orderlineId")
    private List<OrderLine> OrderLine;
}
