package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "Baskets")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_Id")
    private Integer Id;
    private Integer userAccount_Id;
    private Integer orderLine_Id;

    @ManyToOne
    @JoinColumn (name = "orderLineId")
    private OrderLine orderLine;

    @ManyToOne
    @JoinColumn (name = "userAccountId")
    private UserAccount userAccount;
}
