package com.jbk.service;

import com.jbk.entity.CategoryEntity;
import com.jbk.model.CategoryModel;

public interface CategoryService {
	
	public boolean addCategory(CategoryModel categoryModel);
	
	public CategoryModel getCategoryById(long categoryId);
	
	//delete by id and it will return true or false 
	public boolean deleteCategoryById(long categoryId);
	
	//update object of class and it will return true or false
	public boolean updateCategory(CategoryModel categoryModel);

}
