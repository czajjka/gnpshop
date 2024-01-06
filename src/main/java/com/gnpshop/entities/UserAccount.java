package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Entity
@Table(name = "user_accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_account_id")
    private Integer id;

    @Column(name = "user_account_login")
    private String login;

    @Column(name = "user_account_password")
    private String password;

    @Column(name = "user_account_city")
    private String city;

    @Column(name = "user_account_address")
    private String address;

    @Column(name = "user_account_avatar")
    private String avatar;

    @Column(name = "user_account_chanel_preferences")
	private String channelPreferences;

    @OneToMany
    @JoinColumn (name = "basket_id")
    private List<Basket> baskets;

    @ManyToOne
    @JoinColumn (name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn (name = "order_id")
    private Order order;
}