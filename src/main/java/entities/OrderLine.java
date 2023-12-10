package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "OrderLines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderlineId;
    private Integer productId;
    private Integer nrofproducts;
    private BigDecimal productprice;

    @ManyToOne
    @JoinColumn (name = "order_id")
    private Order order;

    @OneToMany(cascade = CascadeType.DETACH)
    private List<Order> order;

}
