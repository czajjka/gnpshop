package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "order_total_price")
    private BigDecimal totalPrice;

    @Column(name = "order_delivery_address")
    private String deliveryAddress;

    @Column(name = "order_creation_date")
    private Integer creationDate;

    @Column(name = "order_order_client")
    private Integer orderClient;

    @Column(name = "order_order_status")
    private String orderStatus;

    @OneToMany
    @JoinColumn (name = "user_account_id")
    private List<UserAccount> userAccount;
}