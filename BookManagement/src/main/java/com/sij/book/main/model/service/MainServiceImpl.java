package com.sij.book.main.model.service;

import org.springframework.stereotype.Service;

import com.sij.book.main.model.dto.Book;
import com.sij.book.main.model.mapper.MainMapper;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
	private final MainMapper mapper;
	
	@Override
	public int bookRegister(Book book) {
		
		return mapper.bookRegister(book);
	}
}
