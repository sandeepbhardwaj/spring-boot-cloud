package com.koko.springboot.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koko.springboot.course.model.Course;
import com.koko.springboot.course.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findUserById(Long id) {
		log.info("Inside findUserById id:{}", id);
		Optional<Course> courseOptional = courseRepository.findById(id);
		log.info("courseOptional:{}", courseOptional);
		return courseOptional.isPresent() ? courseOptional.get() : null;
	}

	@Override
	public Course save(Course user) {
		return courseRepository.save(user);
	}

	@Override
	public List<Course> findAllById(List<Long> courseIds) {
		return courseRepository.findAllById(courseIds);
	}
}
