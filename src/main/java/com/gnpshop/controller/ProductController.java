package com.gnpshop.controller;

import com.gnpshop.service.ProductService;
import org.springframework.stereotype.Controller;


public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

}
