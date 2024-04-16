package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.Board;

public interface EditBoardService {

	/** 게시글 작성
	 * @param inputBoard
	 * @param images
	 * @return result
	 */
	int boardInsert(Board inputBoard, List<MultipartFile> images) throws IllegalStateException, IOException;

	int boardDelete(Map<String, Integer> map);

}
