package com.gnpshop.service.dto;

import com.gnpshop.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddResponse {
    private boolean success;
    private String message;
    private Product product;
}
