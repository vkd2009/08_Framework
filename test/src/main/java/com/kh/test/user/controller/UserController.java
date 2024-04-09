package com.kh.test.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

	private final UserService service;
	
	
	
	
	@PostMapping("select")
	public String select(
			User user,
			Model model,
		 RedirectAttributes ra
		 ) {
		
		 user = service.select(user);
		
		String path = null;
		
		
		if(user == null) {
			path = "/searchSucess";
		}
		if(user != null) {
			model.addAttribute("user", user);
			path = "/searchFail";
		}
		
		return "redirect:";
	}
}
