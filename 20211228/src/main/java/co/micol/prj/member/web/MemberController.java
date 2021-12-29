package co.micol.prj.member.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberDao; //memberServiceImpl ��ȯ //dao �ڵ�����
	
	@Autowired
	private String saveDir; //�������� ���
	
	@RequestMapping("/memberSelectList.do")
	//Model ��ü�� �������� ����.... ����� �Ǿ ������ �������� ������.
	public String memberSelectList(Model model) {
		model.addAttribute("members",memberDao.memberSelectList());
		
		return "member/memberSelectList";
	}
	
	//ȸ������
	@RequestMapping("/memberInsertForm.do")
	public String memberInsertForm() {
		return "member/memberInsertForm";
	}
	
	
	@PostMapping("/memberInsert.do")
	public String memberInsert(@RequestParam("file") MultipartFile file, MemberVO member, Model model) {
		System.out.println(member.getId());
		String originalFileName = file.getOriginalFilename();
				
		if(!originalFileName.isEmpty()) {
			String uuid = UUID.randomUUID().toString();//�������ϸ��� ���� ������ ���̵� ����
			String saveFileName = uuid + originalFileName.substring(originalFileName.lastIndexOf("."));
			
		try {
			file.transferTo(new File(saveDir,saveFileName)); //��������
			member.setPicture(originalFileName);
			member.setPfile(saveFileName);
		} catch(Exception e) {
			e.printStackTrace();
			}
		}
		
		
		 int n= memberDao.memberInsert(member);
		 if(n != 0 ) {
		 model.addAttribute("message","ȸ�������� �����Ǿ����ϴ�.");
		 } else {
		 model.addAttribute("message","ȸ�������� �����ؿ����ϴ�");
		 }
		return "member/memberInsert";
	}
	
	@PostMapping("/ajaxIdCheck.do") //���̵��ߺ�üũ
	@ResponseBody
	public boolean ajaxIsidCheck(String id) {
		System.out.println(id);
		boolean b = memberDao.isIdCheck(id);
		return b;
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
