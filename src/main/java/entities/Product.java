package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
//    private Integer authorId;
//    private Integer categoryId;
    private String productname;
    private String productpescription;
    private String productimage;
    private BigDecimal productprice;
    private String producttype;
    private Integer stockquantity;

    @ManyToOne
    @JoinColumn (name = "categoryId")
    private Category Category;

    @ManyToOne
    @JoinColumn (name = "authorId")
    private Author Author;

    @OneToMany
    @JoinColumn (name = "orderlineId")
    private List<OrderLine> OrderLine;


}
