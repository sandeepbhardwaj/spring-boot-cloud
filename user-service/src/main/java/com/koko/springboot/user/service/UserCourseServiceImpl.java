package com.koko.springboot.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koko.springboot.user.entity.UserCourse;
import com.koko.springboot.user.model.Course;
import com.koko.springboot.user.proxyclient.CourseControllerFeignClient;
import com.koko.springboot.user.repository.UserCourseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserCourseServiceImpl implements UserCourseService {

	@Autowired
	CourseControllerFeignClient feignClient;

	@Autowired
	UserCourseRepository userCourseRepository;

	@Override
	public List<UserCourse> findAllByUserId(Long userId) {
		log.info("Inside findAllByUserId userId: {}", userId);
		List<UserCourse> userCourses = userCourseRepository.findAllByUserId(userId);

		List<Long> courseIds = userCourses.stream().map(o -> o.getCourseId()).collect(Collectors.toList());

		List<Course> courses = getAllUserCourses(courseIds);

		for (UserCourse course : userCourses) {
			Course c = courses.stream().filter(o -> o.getId().equals(course.getCourseId())).findFirst().get();
			course.setCourseName(c.getCourseName());
		}

		log.info("userCourses: {}", userCourses);
		return userCourses;
	}

	private List<Course> getAllUserCourses(List<Long> courseIds) {
		log.info("courseIds: {}", courseIds);
		return feignClient.findAllById(courseIds);
	}
}
