package com.koko.springboot.user.service;

import java.util.List;

import com.koko.springboot.user.entity.User;

public interface UserService {
	List<User> findAll();

	User findUserById(Long id);

	User save(User user);
}
