package com.koko.springboot.user.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Course {
	private Long id;
	private String courseName;
	private String shortDescription;

}
