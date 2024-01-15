package com.gnpshop.service;

import com.gnpshop.entities.Product;
import com.gnpshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> getProductById(final Integer id) {
		return productRepository.findById(id);
	}

	public Optional<Product> addProduct(final Product product) {
		final Optional<Product> qualifiedProduct = findProductById(product.getId());
		if (qualifiedProduct.isPresent()) {
			log.error("Product by id {} already exist", product.getId());
			return Optional.empty();
		}
		productRepository.save(product);
		return Optional.of(product);
	}

	public Optional<Product> deleteProductById(final Integer id) {
		final Optional<Product> qualifiedProduct = findProductById(id);
		if (qualifiedProduct.isPresent()) {
			log.error("Product by id {} not exist", id);
			return Optional.empty();
		}
		productRepository.deleteById(id);
		return Optional.of(qualifiedProduct.get());
	}

	private Optional<Product> findProductById(final Integer id) {
		final List<Product> productList = productRepository.findAll();
		return productList.stream()
				.filter(product -> product.getId().equals(id))
				.findFirst();
	}
}
