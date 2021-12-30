package co.micol.prj.notice.service;

import java.util.List;

public interface NoticeService {

	List<NoticeVO> noticeSelectList();
	
	NoticeVO noticeSelect(NoticeVO notice);
	
	int noticeInsert(NoticeVO notice);
	
	int noticeDelete(NoticeVO notice);
	
	int noticeUpdate(NoticeVO notice);
	
	void noticeHitUpdate(int id);
	
	void noticeIdUpdate(int id);
	
	/* List(NoticeVO) noticeSEarch(String Key, String val); */
}
