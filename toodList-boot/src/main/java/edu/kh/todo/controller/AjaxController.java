package edu.kh.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;
import lombok.extern.slf4j.Slf4j;

/* @ResponseBody
 * - 컨트롤러 메서드의 반환 값을
 * 	 HTTP 응답 본문에 직접 바인딩하는 역활임을 명시
 * 
 * (쉬운 해석)
 * -> 컨트롤러 메서드의 반환 값을
 * 	 비동기 (ajax)요청 했던
 * 	 요청했던 HTML/JS 파일 부분에 값을 돌려 보낼 것이다를 명시
 * 
 * - forward/redirect로 인식 X
 * */

/* @RequestBody
 * - 비동기 요청(ajax) 시 전달되는 데이터 중
 * 	 body 부분에 포함된 용청 데이터를 
 * 	 알맞은 Java 객체 타입으로 바인딩하는 어노테이션
 * 	 
 * (쉬운 설명)
 * - 비동기 요청 시 body에 담긴 값을
 * 	 알맞은 타입으로 변환해서 매개 변수에 저장
 * 
 * */


/* [HttpMessageConverter]
 *  Spring에서 비동기 통신 시
 * - 전달되는 데이터의 자료형
 * - 응답하는 데이터의 자료형
 * 위 두가지 알맞은 형태로 가공(변환)해주는 객체
 * 
 * - 문자열, 숫자 <-> TEXT
 * - Map <-> JSON
 * - DTO <-> JSON
 * 
 * (참고)
 * HttpMessageConverter가 동작하기 위해서는
 * Jackson-data-bind 라이브러리가 필요한데
 * Spring Boot 모듈에 내장되어 있음
 * (Jackson : 자바에서 JSON 다루는 방법 제공하는 라이브러리)
 */



@Slf4j
@RequestMapping("ajax")
@Controller
public class AjaxController {

	// @Autowired
	// - 등록된 bean 중

	@Autowired
	private TodoService service;

	@GetMapping("main")
	public String ajaxMain() {
		return "ajax/main";
	}
	
	// 전체 Todo 개수 조회
	// -> forward / redirect를 원하는 것이 아님!!!
	// -> "전체 Todo 개수"라는 데이터가 반환되는 것을 원함!!!
	
	@ResponseBody // 값 그대로 돌려 보낼꺼야!!!
	@GetMapping("totalCount")
	public int getTotalCount() {
		
		log.info("getTotalCount() 메소드 호출됨!!!"	);
		
		int totalCount = service.getTotalCount();
		
		return totalCount;
	}
	
	
	// completeCount 값을 DB에서 조회해서 그대로 반환
	// -> 값(Data)만 응답하길 원한 --> @ResponseBody 사용
	
	@ResponseBody
	@GetMapping("completeCount")
	public int getCompleteCount() {
		
		return service.getCompleteCount();
	}
	
	
	@ResponseBody // 비동기 요청 결과로 값을 반환
	@PostMapping("add")
	public int addTodo(
//		JSON이 파라미터로 전달된 경우 아래 방법으로 얻어오기 불가능
//		@RequestParam("todoTitle") String todoTitle,
//		@RequestParam("todoContent") String todoContent
			
		@RequestBody Todo todo	// 요청 body에 담긴 값을 Todo에 저장
		) {
		
		log.debug(todo.toString()); 
		int result = service.addTodo(todo.getTodoTitle(), todo.getTodoContent());
		return result;
	}
	
	
	@ResponseBody // 요청했던 패치 부분으로 값을 그대로 돌려보낸다~
	@GetMapping("selectList")
	public List<Todo> selectList() {
		List<Todo> todoList = service.selectList();
		
		return todoList;
		
		// List(Java 전용 타입)를 반환
		// -> JS가 인식할 수 없기 때문에
		//   HttpMessageConverter가 
		//   JSON형태 ([{}, {}, {}] 로 변환하여 반환
        //			   (JSONArray)
	}
	
	
	// 할 일 상세 조회
	@ResponseBody // 요청한 곳으로 데이터 돌려보냄
	@GetMapping("detail")
	public Todo selectTodo(@RequestParam("todoNo") int todoNo) {
		
		// return 자료형 : Todo
		// -> HttpMessageConverter가 String(JSON)형태로 변환해서 반환
		
		
		return service.todoDeatil(todoNo);
	}
	
	
	// Delete 방식 요청 처리 (비동기 요청만 가능!!)
	@ResponseBody
	@DeleteMapping("delete")
	public int todoDelete(@RequestBody int todoNo) {
		return service.todoDelete(todoNo);
	}
	
	
	// 완료 여부 변경
	@ResponseBody
	@PutMapping("changeComplete")
	public int changeComplete(@RequestBody Todo todo ) {
		return service.changeComplete(todo);
	}
	
	
	@ResponseBody
	@PutMapping("update")
	public int todoUpdate(@RequestBody Todo todo) {
		return service.todoUpdate(todo);
	}
	
	
}
	

