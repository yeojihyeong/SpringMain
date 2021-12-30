package co.micol.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberDao;
	
	@RequestMapping("/loginForm.do")
	public String longinForm() {
		return "login";
	}
	
	
	
	@PostMapping("login.do")
	public String login(MemberVO member, HttpSession session) {
		
		member = memberDao.memberSelect(member);
		if(member != null) {
			session.setAttribute("id", member.getId());
			session.setAttribute("author", member.getAuthor());
			session.setAttribute("name", member.getName());
		} else {
			return "login";
		}
		return "redirect:main.do"; //views 경로로 가지말고 바로 main.do로 가라는것
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
	session.invalidate();
	
	return "redirect:main.do";
	}
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		model.addAttribute("members" , memberDao.memberSelectList());
		return "admin/member/memberList";
	}
	
	@RequestMapping("/registerForm.do")
	public String registerForm() {
		return "registerFrom";
	}
	
	@PostMapping("/ajaxIsIdCheck.do")
	@ResponseBody
	public boolean ajaxIsIdCheck(String id) {
		return memberDao.isIdCheck(id);
	}
}
