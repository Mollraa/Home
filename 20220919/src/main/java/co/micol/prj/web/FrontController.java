package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.Main;
import co.micol.prj.common.Command;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;
import co.micol.prj.notice.command.NoticeInsert;
import co.micol.prj.notice.command.NoticeSelect;
import co.micol.prj.notice.command.NoticeSelectList;
import co.micol.prj.notice.command.NoticeWriteForm;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 명령집단 저장하는 곳
		map.put("/main.do", new Main());  //처음 도착하는 페이지 
		map.put("/noticeSelectList.do", new NoticeSelectList()); //notice클릭하면 -> 공지 사항 목록
		map.put("/noticeWriteForm.do", new NoticeWriteForm()); //글쓰기 버튼 누르면 호출
		map.put("/noticeInsert.do", new NoticeInsert()); //글작성 후 등록 호출
		map.put("/noticeSelect.do", new NoticeSelect()); //공지 글 상세보기
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 처리
		map.put("/memberLogout.do", new MemberLogout());  //로그아웃 처리
		
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 수행할 서비스
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		System.out.println("uri - " + uri);
		System.out.println("contextPath - " + contextPath);
		System.out.println("page - " + page);
		System.out.println("------------------------------------");
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}else {
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		}else {
			response.sendRedirect(viewPage);
		}
	}

}
