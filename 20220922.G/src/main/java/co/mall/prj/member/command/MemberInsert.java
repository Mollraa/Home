package co.mall.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mall.prj.common.Command;
import co.mall.prj.member.service.MemberService;
import co.mall.prj.member.service.MemberServiceImpl;
import co.mall.prj.member.service.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
//				member_id VARCHAR2(50) primary key,
//				member_password VARCHAR2(150) not null,
//				member_name VARCHAR2(50),
//				member_name2 VARCHAR2(50),
//				member_tel VARCHAR2(100) not null,
//				member_tel2 VARCHAR2(100),
//				member_address VARCHAR2(500),
//				member_address2 VARCHAR2(500),
//				member_gender VARCHAR2(20),
//				member_birth date,
//				member_email VARCHAR2(200),
//				member_join date default sysdate,
//				member_total_price number default 0,
//				member_point number default 0,
//				member_author VARCHAR2(20)

		
		vo.setMemberId(request.getParameter("memberId"));  //1
		vo.setMemberPassword(request.getParameter("member_password"));//2
		vo.setMemberName(request.getParameter("member_name")); //3
		vo.setMemberName2(request.getParameter("member_name2")); //4
		vo.setMemberTel(request.getParameter("member_tel")); //5
		vo.setMemberTel2(request.getParameter("member_tel2")); //6
		vo.setMemberAddress(request.getParameter("member_address")); //7
		vo.setMemberAddress2(request.getParameter("member_address2")); //8
		vo.setMemberGender(request.getParameter("member_gender")); //9
		vo.setMemberBirth(request.getParameter("member_birth")); //10
		vo.setMemberEmail(request.getParameter("member_email")); //11
		vo.setMemberJoin(request.getParameter("member_join")); //12
		vo.setMemberTotalPrice(Integer.valueOf(request.getParameter("member_total_price"))); //13
		vo.setMemberPoint(Integer.valueOf(request.getParameter("member_point"))); //14
		vo.setMemberAuthor(request.getParameter("member_author")); //15
		
		
		
		return null;
	}

}
