package com.koko.springboot.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koko.springboot.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}