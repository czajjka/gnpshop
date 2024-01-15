package com.gnpshop.controller;

import com.gnpshop.entities.Product;

import com.gnpshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Slf4j
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		final Optional<Product> productById = productService.getProductById(id);
		final String errorMessage = String.format("Category with id %d not found.", id);
		return getProductResponseEntity(productById, errorMessage, HttpStatus.OK, HttpStatus.BAD_REQUEST);
	}

	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Product> addProduct(@Validated @RequestBody final Product product) {
		final Optional<Product> addProduct = productService.addProduct(product);
		final String errorMessage = String.format("Category with id %d not found.", product.getId());
		return getProductResponseEntity(addProduct, errorMessage, HttpStatus.CREATED, HttpStatus.FORBIDDEN);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public ResponseEntity<Product> deleteProductById(@PathVariable final Integer id) {
		Optional<Product> product = productService.deleteProductById(id);
		final String errorMessage = String.format("Category with id %d not found", id);
		return getProductResponseEntity(product, errorMessage, HttpStatus.ACCEPTED, HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<Product> getProductResponseEntity(final Optional<Product> product,
															 final String errorMessage,
															 final HttpStatus successCode,
															 final HttpStatus errorCode) {
		return product.map(
				quariedProduct -> {
					applyLinkToCProduct(quariedProduct);
					return ResponseEntity.status(successCode).body(quariedProduct);
				}).orElseGet(
				() -> {
					log.error(errorMessage);
					return ResponseEntity.status(errorCode).build();
				});
	}

	private void applyLinkToCProduct(final Product product) {
		product.addIf(!product.hasLinks(),
				() -> linkTo(ProductController.class).slash(product.getId()).withSelfRel());
	}
}
