package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

//@Entity
//@Table(name = "Orders")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer webShopOrderId;
    private Integer userAccountId;
    private BigDecimal totalPrice;
    private String deliveryAddress;
    private Integer creationDate;
    private Integer orderClient;
    private String orderStatus;

    @OneToMany
    @JoinColumn (name = "userAccountId")
    private List<UserAccount> userAccount;


}
