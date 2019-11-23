package com.koko.springboot.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koko.springboot.user.entity.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
	List<UserCourse> findAllByUserId(Long userId);
}
