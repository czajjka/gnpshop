package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Baskets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basketId;
    private Integer userAccountId;
    private Integer orderLineId;

    @ManyToOne
    @JoinColumn (name = "orderlineId")
    private OrderLine OrderLine;

    @ManyToOne
    @JoinColumn (name = "useraccountId")
    private UserAccount UserAccount;
}
