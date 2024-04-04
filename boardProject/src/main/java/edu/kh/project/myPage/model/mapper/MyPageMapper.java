package edu.kh.project.myPage.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	/** 회원 정보 수정
	 * @param inputMember
	 * @return result
	 */
	int updateInfo(Member inputMember);

	/** 비밀번호 조회
	 * @param loginMember
	 * @return
	 */
	String change(Member loginMember);

	/** 바뀐 비밀번호
	 * @param loginMember
	 * @return
	 */
	int changePw(Member loginMember);

	/** 회원 탈퇴
	 * @param loginMember
	 * @return
	 */
	int loguout(Member loginMember);

	/** 비밀번호 조회
	 * @param loginMember
	 * @return
	 */
	String selectPw(Member loginMember);

	/** 같을 때 y로 변경
	 * @param loginMember
	 * @return
	 */
	int logOut(Member loginMember);

}
