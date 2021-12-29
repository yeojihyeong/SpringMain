package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	
	//��ü ����Ʈ ��ȸ
	@RequestMapping("/noticeSelectList.do")
	public String noticeSelectList(Model model) {
		
		model.addAttribute("notices",noticeDao.noticeSelectList());
		return "notice/noticeSelectList";
	}
}
