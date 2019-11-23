package com.koko.springboot.course.service;

import java.util.List;

import com.koko.springboot.course.model.Course;

public interface CourseService {
	List<Course> findAll();

	Course findUserById(Long id);

	Course save(Course user);

	List<Course> findAllById(List<Long> courseIds);
}
