package co.micol.prj.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id;
	private String writerId; //�ۼ��� ID
	private String writerName; //�ۼ��� ��
	private Date writeDate;
	private String title;
	private String subject;
	private int hit;
	private String attache; //÷�����ϸ�
}
