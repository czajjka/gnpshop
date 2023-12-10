package entities;

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
    private Integer useraccountId;
    private Integer webshoporderId;
    private String useraccountlogin;
    private String useraccountpassword;
    private String city;
    private String useraddress;
    private String avatar;
    private Integer roleId;
    private String channelpreferences;

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
