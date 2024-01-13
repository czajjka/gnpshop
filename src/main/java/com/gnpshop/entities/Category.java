package com.gnpshop.entities;

import com.gnpshop.repository.CategoryRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends RepresentationModel<Category> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "category_name", columnDefinition = "VARCHAR(50)")
    private String name;

    @OneToMany
    @JoinColumn (name = "product_id")
    private List<Product> product;
}