package com.jbk.dao;

import com.jbk.entity.CategoryEntity;
import com.jbk.model.CategoryModel;

public interface CategoryDao {
	
	public boolean addCategory(CategoryEntity categoryEntity);
	
	public CategoryEntity getCategoryById(long categoryId);
	
	//delete by id and it will return true of false and it require entity class
	public boolean deleteCategoryById(long categoryId);
	
	//update category class object it return true or false and it require entity class
	public boolean updateCategory(CategoryEntity categoryEntity);

}
