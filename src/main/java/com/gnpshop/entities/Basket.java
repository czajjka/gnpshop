package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "baskets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="basket_id")
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "order_line_id")
    private OrderLine orderLine;

    @ManyToOne
    @JoinColumn (name = "user_account_id")
    private UserAccount userAccount;
}