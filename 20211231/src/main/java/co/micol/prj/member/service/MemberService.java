package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {

		List<MemberVO> memberSelectList();
		
		//로그인 and Select
		MemberVO memberSelect(MemberVO member); 
		
		int memberInsert(MemberVO member);
		
		int memberDelete(MemberVO member);
		
		int memberUpdate(MemberVO member);
		
		// 아이디 중복체크
		boolean isIdCheck(String id);
}
