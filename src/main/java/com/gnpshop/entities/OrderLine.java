package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "order_lines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    private Integer id;

    @Column(name = "order_line_number_of_products")
    private Integer nrOfProducts;

    @Column(name = "order_line_product_price")
    private BigDecimal productPrice;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    @OneToMany
    @JoinColumn (name = "basket_id")
    private List<Basket> basket;
}