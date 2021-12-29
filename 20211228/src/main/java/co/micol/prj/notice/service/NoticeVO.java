package co.micol.prj.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id;
	private String writerId; //작성자 ID
	private String writerName; //작성자 명
	private Date writeDate;
	private String title;
	private String subject;
	private int hit;
	private String attache; //첨부파일명
}
