package com.gnpshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends RepresentationModel<Category> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_image")
    private String image;

    @Column(name = "product_price")
    private BigDecimal price;

    @Column(name = "product_type")
    private String type;

    @Column(name = "product_stock_quantity")
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn (name = "author_id")
    private Author author;

    @OneToMany
    @JoinColumn (name = "order_line_id")
    private List<OrderLine> orderLine;
}