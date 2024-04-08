package com.sij.book.main.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sij.book.main.model.dto.Book;

@Mapper
public interface MainMapper {

	int bookRegister(Book book);

	

	

	

}
