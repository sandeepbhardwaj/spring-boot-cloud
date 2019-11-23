package com.koko.springboot.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koko.springboot.user.entity.User;
import com.koko.springboot.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> findAll() {
		log.info("Inside findAll");
		return userService.findAll();
	}

	@PostMapping
	public User save(@RequestBody User user) {
		log.info("Inside save user: {}", user);
		return userService.save(user);
	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id) {
		log.info("Inside findUserById id:{}", id);
		return userService.findUserById(id);
	}
}
