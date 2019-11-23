package com.koko.springboot.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koko.springboot.user.entity.User;
import com.koko.springboot.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Long id) {
		log.info("Inside findUserById id:{}", id);
		Optional<User> userOptional = userRepository.findById(id);
		log.info("userOptional:{}", userOptional);
		return userOptional.isPresent() ? userOptional.get() : null;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
}
