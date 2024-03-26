package edu.kh.todo.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.todo.model.dto.Todo;

/**
 * 
 */
public interface TodoService {

	/** 할 일 목록 + 완료된 할 일 개수 조회
	 * @return map
	 */
	
	Map<String, Object> selectAll();

	/** 할 일 추가
	 * @param todoTitle
	 * @param todoContent
	 * @return result
	 */
	int addTodo(String todoTitle, String todoContent);

	/** 할 일 상세 조회
	 * @param todoNo
	 * @return todo
	 */
	Todo todoDeatil(int todoNo);

	/** 할 일 삭제
	 * @param todoNo
	 * @return result
	 */
	int todoDelete(int todoNo);

	/** 할 일 수정
	 * @param todo
	 * @return result
	 */
	int todoUpdate(Todo todo);

	/** 완료 여부 변경
	 * @param todo
	 * @return result
	 */
	int changeComplete(Todo todo);

	/** 완료된 할 일 개수 조회
	 * @return
	 */
	int getCompleteCount();

	/** 전체 할일 개수 조회
	 * @return
	 */
	int getTotalCount();

	/** 할 일 목록 조회
	 * @return
	 */
	List<Todo> selectList();

	
	
	

	
	

	
}
