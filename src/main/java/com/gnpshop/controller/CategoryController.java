package com.gnpshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.gnpshop.entities.Category;
import com.gnpshop.service.CategoryService;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Slf4j
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
		final Optional<Category> categoryById = categoryService.getCategoryById(id);
		final String errorMessage = String.format("Category with id %d not found.", id);
		return getCategoryResponseEntity(categoryById, errorMessage, HttpStatus.OK, HttpStatus.NOT_FOUND);
	}

	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Category> addCategory(@Validated @RequestBody final Category category) {
		final Optional<Category> addCategory = categoryService.addCategory(category);
		final String errorMessage = String.format("Category with id %d not found.", category.getId());
		return getCategoryResponseEntity(addCategory, errorMessage, HttpStatus.CREATED, HttpStatus.FORBIDDEN);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public ResponseEntity<Category> deleteCategoryById(@PathVariable final Integer id) {
		Optional<Category> category = categoryService.deleteCategoryById(id);
		final String errorMessage = String.format("Category with id %d not found", id);
		return getCategoryResponseEntity(category, errorMessage, HttpStatus.ACCEPTED, HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<Category> getCategoryResponseEntity(final Optional<Category> category,
															   final String errorMessage,
															   final HttpStatus successCode,
															   final HttpStatus errorCode) {
		return category.map(
				quariedCategory -> {
					applyLinkToCategory(quariedCategory);
					return ResponseEntity.status(successCode).body(quariedCategory);
				}).orElseGet(
				() -> {
					log.error(errorMessage);
					return ResponseEntity.status(errorCode).build();
				});
	}

	private void applyLinkToCategory(final Category category) {
		category.addIf(!category.hasLinks(),
				() -> linkTo(CategoryController.class).slash(category.getId()).withSelfRel());
	}
}
