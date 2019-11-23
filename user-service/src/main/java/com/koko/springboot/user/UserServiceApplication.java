package com.koko.springboot.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.koko.springboot.user.entity.User;
import com.koko.springboot.user.repository.UserRepository;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner save(UserRepository repository) {
		User user = User.builder().firstName("Sumit").lastName("Gupta").email("abc@gmail.com").build();
		return args -> repository.save(user);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
