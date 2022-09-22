package co.mall.prj.member.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
//	member_id VARCHAR2(50) primary key , 
//	member_password VARCHAR2(150) not null,
//	member_name VARCHAR2(50),
//	member_name2 VARCHAR2(50),
//	member_tel VARCHAR2(150) not null,
//	member_tel2 VARCHAR2(150) not null,
//	member_address VARCHAR2(300),
//	member_address2 VARCHAR2(300),
//	member_gender VARCHAR2(50),
//	member_birth date,
//	member_email VARCHAR2(200),
//	member_join date default sysdate not null,
//	member_total_price number default 0,
//	member_point number default 0, 
//	member_author VARCHAR2(50)
	private String memberId; //pk 회원아이디
	private String memberPassword; //비밀번호
	private String memberName; //이름
	private String memberName2; //이름2
	private String memberEmail; //이메일
	private String memberTel; //전화번호
	private String memberTel2; //전화번호2
	private String memberAddress; //회원 주소
	private String memberAddress2; //회원 주소 2
	private String memberGender; //성별
	private String memberBirth; //생일
	private String memberJoin; //가입일
	private int memberTotalPrice; //총 구매 금액(누적)
	private int memberPoint; //로그인, 물건 구매 시 쌓이는 회원 포인트(누적, 사용가능)
	private String memberAuthor; //회원or 운영진 구분

}
