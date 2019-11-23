package com.koko.springboot.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koko.springboot.user.entity.UserCourse;
import com.koko.springboot.user.service.UserCourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/courses")
public class UserCourseController {
	@Autowired
	UserCourseService courseService;

	@GetMapping("/{userId}")
	private List<UserCourse> findAllByUserId(@PathVariable Long userId) {
		log.info("Inside findAllByUserId userId: {}", userId);
		return courseService.findAllByUserId(userId);
	}
}
