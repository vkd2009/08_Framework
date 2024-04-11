package com.sij.book.main.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sij.book.main.model.dto.Book;

@Mapper
public interface MainMapper {

	int bookRegister(Book book);

	/** 전체 목록 조회
	 * @return
	 */
	List<Book> selectList();

	

	

	

}
