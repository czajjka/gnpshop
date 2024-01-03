package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
//    private Integer authorId;
//    private Integer categoryId;
    private String productName;
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
