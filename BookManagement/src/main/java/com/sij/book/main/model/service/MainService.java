package com.sij.book.main.model.service;

import com.sij.book.main.model.dto.Book;

public interface MainService {

	/** 할 일 등록
	 * @param book
	 * @return
	 */
	int bookRegister(Book book);

	
}
