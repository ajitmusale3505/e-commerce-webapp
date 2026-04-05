package com.jsp.ecommerce.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.ecommerce.entity.Users;
import com.jsp.ecommerce.exception.NoSuchResourceException;
import com.jsp.ecommerce.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo repo;

	@Override
	public Users insertuser(Users user) {
		return repo.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
		 List<Users> all = repo.findAll();
		return all;
	}

	@Override
	public Users getByData(String id) {
		if (repo.findById(id).isEmpty()) {
			throw new NoSuchResourceException(id+ " Object is not Present in db");
		}
		return repo.findById(id).get();
	}

	@Override
	public void deleteById(String id) {
		if (repo.findById(id).isEmpty()) {
			throw new NoSuchResourceException(id+ " Object is not Present in db");
		}
		repo.deleteById(id);
	}

	@Override
	public Users updateAll(Users user) {
		return repo.save(user);
	}

	@Override
	public Users updateById(String id, String name) {
		if (repo.findById(id).isEmpty()) {
			throw new NoSuchResourceException(id+ " Object is not Present in db");
		}
		Users users = repo.findById(id).get();
		users.setName(name);
		repo.save(users);
		return users;
	}

	@Override
	public Users updateById(String id, String email, String pass) {
		if (repo.findById(id).isEmpty()) {
			throw new NoSuchResourceException(id+ " Object is not Present in db");
		}
		Users users = repo.findById(id).get();
		users.setEmail(email);
		users.setPassword(pass);
		repo.save(users);
		return users;
	}

	 
	
	
}
