package co.micol.prj.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO member); //한명 조회 and 로그인 까지 사용
	int memberInsert(MemberVO member);
	int memberDelete(MemberVO member);
	int memberUpdate(MemberVO member);
	
	boolean isIdCheck(String id);
	List<MemberVO> memberSearch(@Param("key") String key,@Param("data") String data);
}
