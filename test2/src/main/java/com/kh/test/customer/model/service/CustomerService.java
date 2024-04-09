package com.kh.test.customer.model.service;

import org.springframework.stereotype.Service;

import com.kh.test.customer.model.dto.Customer;

@Service

public interface CustomerService {

	int customerAdd(Customer customer);

	

}
