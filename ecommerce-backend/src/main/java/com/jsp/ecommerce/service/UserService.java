package com.jsp.ecommerce.service;
import java.util.List;

import com.jsp.ecommerce.entity.Users;

public interface UserService{
	
	public Users insertuser(Users user);
	public List<Users> getAllUsers();
	public Users getByData(String id);
	public void deleteById(String id);
	public Users updateAll(Users user);
    public Users updateById(String id, String name);
    public Users updateById(String id, String email,String pass);
	
	
	
}
