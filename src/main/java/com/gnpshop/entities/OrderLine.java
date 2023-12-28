package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "OrderLines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderLineId;
    private Integer productId;
    private Integer nrOfProducts;
    private BigDecimal productPrice;

    @ManyToOne
    @JoinColumn (name = "productId")
    private Product product;

    @OneToMany
    @JoinColumn (name = "basketId")
    private List<Basket> Basket;

}
