package co.mall.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mall.prj.Main;
import co.mall.prj.common.Command;
import co.mall.prj.member.command.MemberInsert;
import co.mall.prj.member.command.MemberLogin;
import co.mall.prj.member.command.MemberLoginForm;
import co.mall.prj.member.command.MemberLogout;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.yd")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 명령집단 저장
		map.put("/main.yd", new Main()); //첫 화면
		map.put("/memberLoginForm.yd", new MemberLoginForm()); //로그인 폼
		map.put("/memberLogin.yd", new MemberLogin()); // 폼 액션 -> 로그인
		map.put("/memberLogout.yd", new MemberLogout()); //로그아웃
		map.put("/memberInsert.yd", new MemberInsert()); //회원가입
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제수행 기능
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		System.out.println("uri: " + uri);
		System.out.println("page: " + page);

		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		if (!viewPage.endsWith(".yd")) {
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
//			} else {
//				if(viewPage.startsWith("no:")) {
//					viewPage = "/WEB-INF/views/" + viewPage.substring(3) + ".jsp";
//				} else {
//					viewPage = viewPage + ".tiles";  //tiles layout 사용	=  <definition name="WILDCARD:*/*" extends="myapp.homepage">
//				}
			} else { // 리턴값이 보여줄 페이지를 가지고 올때
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
			System.out.println("viewPage: " + viewPage);
		} else {
			response.sendRedirect(viewPage); // .yd return
			
		}
	}
}
