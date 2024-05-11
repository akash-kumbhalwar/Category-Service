package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.CategoryModel;
import com.jbk.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	//1. Adding a category
	@PostMapping("add-category")
	public ResponseEntity<String> addCategory(@RequestBody @Valid CategoryModel categoryModel){
		
		service.addCategory(categoryModel);
		return ResponseEntity.ok("Category Added Successfully..!!");	
	}
	
	//2. Get category by id it will return a complete object
	@GetMapping("get-category-by-id/{categoryId}")
	public ResponseEntity<CategoryModel> getCategoryById(@PathVariable long categoryId){
		
		CategoryModel categoryModel = service.getCategoryById(categoryId);
		
		return ResponseEntity.ok(categoryModel);
		
		
	}
	
	//3. Delete by id it will return message
	@DeleteMapping("delete-category-by-id")
	public ResponseEntity<String> deleteCategoryById(@RequestParam("categoryId") long categoryId){
		service.deleteCategoryById(categoryId);
		return ResponseEntity.ok("Category deleted successfully..!!");
		
	}
	
	//4. update object of class by model class it will return message
	@PutMapping("update-category")
	public ResponseEntity<String> updateCategory(@RequestBody CategoryModel categoryModel){
		service.updateCategory(categoryModel);
		
		return ResponseEntity.ok("Category Updated");
		
		
	}
	
	

}
