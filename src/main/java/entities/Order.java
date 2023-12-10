package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer webshoporderId;
    private Integer useraccountId;
    private BigDecimal totalprice;
    private String deliveryaddress;
    private Integer creationdate;
    private Integer orderclient;
    private String orderstatus;

    @ManyToOne
    @JoinColumn (name = "useraccount_id")
    private UserAccount userAccount;
}
