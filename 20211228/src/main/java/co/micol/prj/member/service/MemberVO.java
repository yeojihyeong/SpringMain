package co.micol.prj.member.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String author;
	private String tel;
	private String address;
	private String picture;
	private String pfile;
}
