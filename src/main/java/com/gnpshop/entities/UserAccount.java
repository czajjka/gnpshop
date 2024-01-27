package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 15)
    private String login;

    @Column(length = 15)
    private String password;

    @Column(length = 90)
    private String city;

    @Column(length = 100)
    private String address;

    @Column
    private String avatar;

    @Column(name = "chanel_preferences", length = 50)
	private String channelPreferences;

    @OneToMany
    @JoinColumn
    private List<Basket> baskets;

    @ManyToOne
    @JoinColumn (name = "role_id")
    private Role role;

    @OneToMany
    @JoinColumn
    private List<Order> order;
}