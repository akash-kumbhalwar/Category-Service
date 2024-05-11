package com.jbk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;
import com.jbk.exception.ResourceAlreadyExistException;
import com.jbk.exception.ResourceNotExistException;
import com.jbk.exception.SomethingWentWrongException;


@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	//1. add category
	//2. something went wrong during add category
	
	@Override
	public boolean addCategory(CategoryEntity categoryEntity) {
		boolean isAdded=false;
		try {
			Session session = sessionFactory.openSession();
			
			CategoryEntity dbCategory = getCategoryById(categoryEntity.getCategoryId());
			if(dbCategory==null) {
				session.save(categoryEntity);
				session.beginTransaction().commit();
				isAdded=true;
			}else {
				throw new ResourceAlreadyExistException("Category already exist with Id:-"+categoryEntity.getCategoryId());
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went Wrong during add category");
		}
		return isAdded;
	}

	//1. get category
	//2. not exist
	//3. something went wrong 
	
	@Override
	public CategoryEntity getCategoryById(long categoryId) {
		CategoryEntity categoryEntity=null;
		try {
		Session session = sessionFactory.openSession();
		
		 categoryEntity = session.get(CategoryEntity.class, categoryId);
		session.beginTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went Wrong during get category");
			
		}
		return categoryEntity;
	}

	@Override
	public boolean deleteCategoryById(long categoryId) {
		boolean isDeleted=false;
		try {
		Session session = sessionFactory.openSession();
		CategoryEntity categoryEntity = session.get(CategoryEntity.class, categoryId);
		if(categoryEntity != null) {
			session.delete(categoryEntity);
			session.beginTransaction().commit();
			isDeleted=true;
		}else {
			throw new ResourceNotExistException("Category not exist with Id:-"+categoryId);
		}
		}catch(Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something went wrong during delete");
			
		}
		
		return isDeleted;
	}

	@Override
	public boolean updateCategory(CategoryEntity categoryEntity) {
		boolean isUpdated=false;
		try {
			Session session = sessionFactory.openSession();
			CategoryEntity dbCategory = getCategoryById(categoryEntity.getCategoryId());
			if(dbCategory!=null) {
				session.update(categoryEntity);
				session.beginTransaction().commit();
				isUpdated=true;
			}else {
				throw new ResourceNotExistException("Category not exist with Id:-"+categoryEntity.getCategoryId());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went Wrong during update category");
			
		}
		return isUpdated;
	}

}
