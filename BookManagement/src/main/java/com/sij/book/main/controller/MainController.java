package com.sij.book.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sij.book.main.model.dto.Book;
import com.sij.book.main.model.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final MainService service;
	
	@RequestMapping("/")
	public String mainPage() {
		return "common/main";
	}

	@GetMapping("book/register")
	public String register() {
		return "book/register";
	}
	
	
	@GetMapping("book/management")
	public String management() {
		return "book/management";
	}
	
	@PostMapping("book/book_register")
	public String book_register(
		@ModelAttribute Book book,
		RedirectAttributes rs
		) {
		
		int result = service.bookRegister(book);
		
		String message = null;
		String path = null;
		
		if(result > 0) {
		message = "등록 성공";
		path ="/";
		} else {
			message = "등록 실패";
			path = "/book/register";
		}
		
		rs.addFlashAttribute("message", message);
		
		
		return "redirect:" + path;
	}

	@ResponseBody
	@PostMapping("selectList")
	public List<Book> selectList(){
		return service.selectList();
	}
	
}
