package com.kh.test.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class CustomerController {
	
	private final CustomerService service;

	@PostMapping("test1")
	public String test1(
			@ModelAttribute Customer customer,
			RedirectAttributes ra,
			Model model
			) {
		
		int result = service.customerAdd(customer);
		
		String path = null;
		
		if(result > 0) {
			path = "result";
			
		}else {
			path = "/";
		}
		return path;
		
		
		
		
		
	}
}
