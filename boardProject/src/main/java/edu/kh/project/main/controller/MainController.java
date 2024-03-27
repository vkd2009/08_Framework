package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Bean 등록
public class MainController {

	@RequestMapping("/") // "/" 요청 매핑(method 가리지 않음 (get이든 post이든 다 받아 내겠다))
	public String mainPage() {
		
		return "common/main"; // common/main으로 포워드 하겠다.
	}
}
