package co.micol.prj.notice.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {

	private int id;
	private String writerId;
	private String writerName;
	private Date writeDate;
	private String title;
	private String subject;
	private int hit;
	private String attache;
}
