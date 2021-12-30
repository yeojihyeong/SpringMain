package co.micol.prj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.notice.service.NoticeMapper;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;

@Repository("noticeDao")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper map;
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO notice) {
		return  map.noticeSelect(notice);
	}

	@Override
	public int noticeInsert(NoticeVO notice) {
		return map.noticeInsert(notice);
	}

	@Override
	public int noticeDelete(NoticeVO notice) {
		return map.noticeDelete(notice);
	}

	@Override
	public int noticeUpdate(NoticeVO notice) {
		return map.noticeUpdate(notice);
	}

	@Override
	public void noticeHitUpdate(int id) {
		map.noticeHitUpdate(id);
	}

	@Override
	public void noticeIdUpdate(int id) {
		map.noticeIdUpdate(id);
		
		
	}


	
}
