package co.micol.prj.member.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberDao; //memberServiceImpl ��ȯ //dao �ڵ�����
	
	@RequestMapping("/memberSelectList.do")
	//Model ��ü�� �������� ����.... ����� �Ǿ ������ �������� ������.
	public String memberSelectList(Model model) {
		model.addAttribute("members",memberDao.memberSelectList());
		
		return "member/memberSelectList";
	}
	
	
	@RequestMapping("/memberLoginForm.do") //�ܼ��� �Է����� ȣ���Ҷ�
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO member, Model model, HttpSession session) {
		member = memberDao.memberSelect(member);
		if(member != null) {
			session.setAttribute("id", member.getId()); //���ǿ� ���̵� ��´�  key, value �� ��´�.
			session.setAttribute("author", member.getAuthor()); //���ǿ� ������ ��´�
			model.addAttribute("message", member.getName()+"�� ȯ���մϴ�.");			
		} else {
			model.addAttribute("message", "���̵� �Ǵ� �н����尡 Ʋ���ϴ�.");
		}
		return "member/memberLogin";
	}
	
	
	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
		session.invalidate(); //������ �������� �����Ѵ�.
		model.addAttribute("message","�α׾ƿ��� ���������� ó�� �Ǿ����ϴ�.");
		return "member/memberLogout";
	}
	
	
	@PostMapping("/ajaxSearchMember.do")
	@ResponseBody
	public List<MemberVO> ajaxSearchMember(
			@RequestParam("key") String key, @RequestParam("data") String data){
		return memberDao.memberSearch(key, data);
	}
	
	
	
	
	
	
	
	@PostMapping("/memberJoin.do") //post������� ���� get����϶��� 403 ����
	public String memberJoin(MemberVO member, Model model) {
		return "member/memberJoin";
	}
	
	@GetMapping("/memberRead.do") //get������� ���� post����϶��� 403 ����
	public String memberRead(String id, Model model) {
		return "member/memberRead";
	}
}
