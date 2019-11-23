package com.koko.springboot.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class GreetingController {
	@Autowired
	private Environment environment;

	@GetMapping
	public String greeting() {
		log.info("Inside greeting");
		return environment.getProperty("spring.application.name") + " running on port "
				+ environment.getProperty("server.port");
	}

}
