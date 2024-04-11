package com.sij.book.main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	public List<Book> selectList() {
		return mapper.selectList();
	}
}
