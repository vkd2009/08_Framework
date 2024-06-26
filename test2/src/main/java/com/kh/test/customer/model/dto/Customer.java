package com.kh.test.customer.model.dto;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Customer {
	
	private int customerNo;
	private String customerName;
	private String customerTel;
	private String customerAddress;
}
