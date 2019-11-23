package com.koko.springboot.user.service;

import java.util.List;

import com.koko.springboot.user.entity.UserCourse;

public interface UserCourseService {
	List<UserCourse> findAllByUserId(Long userId);
}
