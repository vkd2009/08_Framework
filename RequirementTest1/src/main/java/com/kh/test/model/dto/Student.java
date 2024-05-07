package com.kh.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor

public class Student {
	
	private int studentNo;
	private String studentName;
	private String studentMajor;
	private String studentGender;
}
