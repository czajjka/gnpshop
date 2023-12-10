package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private Integer authorId;
    private Integer categoryId;
    private String productname;
    private String productpescription;
    private String productimage;
    private BigDecimal productprice;
    private String producttype;
    private Integer stockquantity;

    @OneToMany
    @JoinColumn (name = "orderline_id")
    private OrderLine OrderLine;


}
