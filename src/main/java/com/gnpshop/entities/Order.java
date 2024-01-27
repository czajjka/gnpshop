package com.gnpshop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "total_price",columnDefinition = "DEFAULT 0.0")
    @Digits(integer = 8, fraction = 2)
    private BigDecimal totalPrice;

    @Column(name = "delivery_address", length = 100)
    private String deliveryAddress;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "order_client", length = 50)
    private Integer orderClient;

    @Column(name = "order_status", length = 50)
    private String orderStatus;

    @ManyToOne
    @JoinColumn (name = "user_account_id")
    private UserAccount userAccount;
}