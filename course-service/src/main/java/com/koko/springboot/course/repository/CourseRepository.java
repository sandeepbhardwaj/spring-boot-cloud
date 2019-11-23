package com.koko.springboot.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koko.springboot.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}