package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {

		List<MemberVO> memberSelectList();
		
		//�α��� and Select
		MemberVO memberSelect(MemberVO member); 
		
		int memberInsert(MemberVO member);
		
		int memberDelete(MemberVO member);
		
		int memberUpdate(MemberVO member);
		
		// ���̵� �ߺ�üũ
		boolean isIdCheck(String id);
}
