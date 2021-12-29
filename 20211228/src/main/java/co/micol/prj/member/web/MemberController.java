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
	private MemberService memberDao; //memberServiceImpl 소환 //dao 자동주입
	
	@Autowired
	private String saveDir; //파일저장 경로
	
	@RequestMapping("/memberSelectList.do")
	//Model 객체는 스프링이 제공.... 결과를 실어서 전달할 페이지에 보내줌.
	public String memberSelectList(Model model) {
		model.addAttribute("members",memberDao.memberSelectList());
		
		return "member/memberSelectList";
	}
	
	//회원가입
	@RequestMapping("/memberInsertForm.do")
	public String memberInsertForm() {
		return "member/memberInsertForm";
	}
	
	
	@PostMapping("/memberInsert.do")
	public String memberInsert(@RequestParam("file") MultipartFile file, MemberVO member, Model model) {
		System.out.println(member.getId());
		String originalFileName = file.getOriginalFilename();
				
		if(!originalFileName.isEmpty()) {
			String uuid = UUID.randomUUID().toString();//물리파일명을 위한 교유한 아이디 생성
			String saveFileName = uuid + originalFileName.substring(originalFileName.lastIndexOf("."));
			
		try {
			file.transferTo(new File(saveDir,saveFileName)); //파일저장
			member.setPicture(originalFileName);
			member.setPfile(saveFileName);
		} catch(Exception e) {
			e.printStackTrace();
			}
		}
		
		
		 int n= memberDao.memberInsert(member);
		 if(n != 0 ) {
		 model.addAttribute("message","회원가입이 성공되었습니다.");
		 } else {
		 model.addAttribute("message","회원가입이 실패해였습니다");
		 }
		return "member/memberInsert";
	}
	
	@PostMapping("/ajaxIdCheck.do") //아이디중복체크
	@ResponseBody
	public boolean ajaxIsidCheck(String id) {
		System.out.println(id);
		boolean b = memberDao.isIdCheck(id);
		return b;
	}
	
	@RequestMapping("/memberLoginForm.do") //단순히 입력폼을 호출할때
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO member, Model model, HttpSession session) {
		member = memberDao.memberSelect(member);
		if(member != null) {
			session.setAttribute("id", member.getId()); //세션에 아이디값 담는다  key, value 로 담는다.
			session.setAttribute("author", member.getAuthor()); //세션에 권한을 담는다
			model.addAttribute("message", member.getName()+"님 환영합니다.");			
		} else {
			model.addAttribute("message", "아이디 또는 패스워드가 틀립니다.");
		}
		return "member/memberLogin";
	}
	
	
	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
		session.invalidate(); //세션을 서버에서 삭제한다.
		model.addAttribute("message","로그아웃이 정상적으로 처리 되었습니다.");
		return "member/memberLogout";
	}
	
	
	@PostMapping("/ajaxSearchMember.do")
	@ResponseBody
	public List<MemberVO> ajaxSearchMember(
			@RequestParam("key") String key, @RequestParam("data") String data){
		return memberDao.memberSearch(key, data);
	}
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/memberJoin.do") //post방식으로 전달 get방식일때는 403 오류
	public String memberJoin(MemberVO member, Model model) {
		return "member/memberJoin";
	}
	
	@GetMapping("/memberRead.do") //get방식으로 전달 post방식일때는 403 오류
	public String memberRead(String id, Model model) {
		return "member/memberRead";
	}
}
