package com.joecui.web.service;

import com.joecui.web.entity.User;
import java.util.List;

public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();

	void saveOrUpdate(User user);
	
	void delete(int id);
	
}