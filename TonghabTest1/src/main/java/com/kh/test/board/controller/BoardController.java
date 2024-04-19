package com.kh.test.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	 @GetMapping("select")
	 public String select(
		Board board,
		@RequestParam("boardTitle")
		Model model
		) {
		 
		 List<Board> boardList = new ArrayList<>(); 
		 board = service.select(boardList);
		 
		 String path = null;
		 
		 if(board != null) {
			 path = "/searchSuccess";
			 model.addAttribute(board);
		 } else {
			 path = "/searchFail";
		 }
		 
		 
		 
		 return path;
	 }
}
