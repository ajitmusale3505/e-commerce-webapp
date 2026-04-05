package com.jsp.ecommerce.service;

import java.util.List;

import com.jsp.ecommerce.entity.Category;
import com.jsp.ecommerce.entity.Users;

public interface CategoryService {
	public Category insertCategory(Category category);
	public List<Category> getAllCategory();
	public Category getByData(String id);
	public void deleteById(String id);
	public Category updateAll(Category cateogry);
    public Category updateById(String id, String name);
    public Category updateByIdDesc(String id, String desc);
	
}
