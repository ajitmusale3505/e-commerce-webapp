package com.jsp.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ecommerce.entity.Category;
import com.jsp.ecommerce.entity.Users;
import com.jsp.ecommerce.exception.NoSuchResourceException;
import com.jsp.ecommerce.repo.CategoryRepo;
import com.jsp.ecommerce.repo.UserRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo repo;


	@Override
	public Category insertCategory(Category category) {
		return repo.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> all = repo.findAll();
		return  all;
	}

	@Override
	public Category getByData(String id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteById(String id) {
		 repo.deleteById(id);
	}

	@Override
	public Category updateById(String id, String name) {
		Category category = repo.findById(id).get();
		category.setName(name);
		repo.save(category);
		return category;
	}

	@Override
	public Category updateByIdDesc(String id, String desc) {
		Category category = repo.findById(id).get();
		category.setDescription(desc);
		return null;
	}

	@Override
	public Category updateAll(Category cateogry) {
		 repo.save(cateogry);
		return  cateogry;
	} 
}
