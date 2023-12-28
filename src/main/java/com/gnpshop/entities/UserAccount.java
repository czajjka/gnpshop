package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "UserAccounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userAccountId;
    private Integer webShopOrderId;
    private String userAccountLogin;
    private String userAccountPassword;
    private String city;
    private String userAddress;
    private String avatar;
    private Integer roleId;
    private String channelPreferences;

    @OneToMany
    @JoinColumn (name = "basketId")
    private List<Basket> baskets;

    @ManyToOne
    @JoinColumn (name = "roleId")
    private Role Role;

    @ManyToOne
    @JoinColumn (name = "useraccountId")
    private UserAccount UserAccount;
}
