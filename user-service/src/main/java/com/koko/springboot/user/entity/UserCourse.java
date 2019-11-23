package com.koko.springboot.user.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@IdClass(UserCourse.IdClass.class)
public class UserCourse {
	@Id
	private Long userId;
	@Id
	private Long courseId;
	@Transient
	private String courseName;

	@Data
	static class IdClass implements Serializable {
		private static final long serialVersionUID = 1L;
		private Long userId;
		private Long courseId;
	}
}
