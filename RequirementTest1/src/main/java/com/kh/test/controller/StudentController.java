package com.kh.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.test.model.dto.Student;
import com.kh.test.model.service.StudentService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController implements StudentService{

	private final StudentService service;
	
	@ResponseBody
	@GetMapping("selectList")
	public List<Student> selectList() {
		return service.selectList();
	}
}
