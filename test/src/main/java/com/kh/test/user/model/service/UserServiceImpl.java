package com.kh.test.user.model.service;

import org.springframework.stereotype.Service;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserMapper mapper;
	
	@Override
	public User select(User user1) {
		
		return mapper.select(user1);
	}

	
}
