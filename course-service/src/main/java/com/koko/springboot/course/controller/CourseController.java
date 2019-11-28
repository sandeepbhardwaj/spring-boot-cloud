package com.koko.springboot.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koko.springboot.course.model.Course;
import com.koko.springboot.course.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	public List<Course> findAll() {
		log.info("Inside findAll");
		return courseService.findAll();
	}

	@GetMapping(params = "id")
	public List<Course> findAllById(@RequestParam("id") List<Long> courseIds) {
		log.info("Inside findAllById courseIds:{}", courseIds);
		return courseService.findAllById(courseIds);
	}

	@PostMapping
	public Course save(@RequestBody Course course) {
		log.info("Inside save course: {}", course);
		return courseService.save(course);
	}

	@GetMapping("/{id}")
	public Course findUserById(@PathVariable Long id) {
		log.info("Inside findUserById id:{}", id);
		return courseService.findUserById(id);
	}
}
