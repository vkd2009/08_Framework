package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {
	
	private final UserService service;
	
	
	@GetMapping("select")
	public String select(
			User user,
			Model model
		
		 ) {
		
		 user = service.select(user);
		
		String path = null;
		
		
		if(user == null) {
			path = "searchFail";
		}
		if(user != null) {
			model.addAttribute("user", user);
			path = "searchSuccess";
		}
		
		return  path;
	}
}
