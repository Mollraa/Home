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

import co.mall.prj.board.command.Notice;
import co.mall.prj.cart.command.Cart;
import co.mall.prj.command.Best;
import co.mall.prj.command.Checkout;
import co.mall.prj.command.Main;
import co.mall.prj.command.Shop;
import co.mall.prj.common.Command;
import co.mall.prj.member.command.Login;
import co.mall.prj.member.command.Member;
import co.mall.prj.member.command.MemberEditForm;
import co.mall.prj.member.command.MemberInsert;
import co.mall.prj.member.command.MemberLogin;
import co.mall.prj.member.command.MemberLoginForm;
import co.mall.prj.member.command.MemberLogout;
import co.mall.prj.member.command.MemberOrderHistory;
import co.mall.prj.member.command.SignUP;
import co.mall.prj.page.command.Bottom;
import co.mall.prj.page.command.Outer;
import co.mall.prj.page.command.Top;
import co.mall.prj.product.Command.ProductDetail;
import co.mall.prj.member.command.AjaxMemberIdCheck;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.yd")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.yd", new Main());
		map.put("/shop.yd", new Shop());
		map.put("/cart.yd", new Cart());
		map.put("/checkout.yd", new Checkout());
		map.put("/productDetail.yd", new ProductDetail());
		map.put("/member.yd", new Member());

		
		map.put("/top.yd", new Top());
		map.put("/bottom.yd", new Bottom());
		map.put("/outer.yd", new Outer());
		
		map.put("/best.yd", new Best());
		map.put("/signUp.yd", new SignUP());
		map.put("/login.yd", new Login());
		
		// member ???????????? ??????
		map.put("/main.yd", new Main()); //??? ??????
		map.put("/memberLoginForm.yd", new MemberLoginForm()); //????????? ???
		map.put("/memberLogin.yd", new MemberLogin()); // ??? ?????? -> ?????????
		map.put("/memberLogout.yd", new MemberLogout()); //????????????
		map.put("/memberInsert.yd", new MemberInsert()); //????????????
		map.put("/ajaxMemberIdCheck.yd", new AjaxMemberIdCheck()); //????????? ????????????
		//member ??????????????? -> ?????? ?????? / ???????????? / ?????? / ?????? ????????? 
		map.put("/memberEditForm.yd", new MemberEditForm()); //mypage(????????????) ???
		map.put("/memberOrderHistory.yd", new MemberOrderHistory()); //????????????
		
		map.put("/notice.yd", new Notice());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		System.out.println("page : " + page);
	
		Command command = map.get(page);

		String viewPage = command.exec(request, response);

		System.out.println("??????????????? viewPage : " + viewPage);
		System.out.println("------------------------------------------");
		
		if (!viewPage.endsWith(".yd")) {
			if (viewPage.startsWith("ajax:")) { //ajax??? ????????? ???
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			} else {
				if (viewPage.startsWith("no:")) { // Tiles ?????? ?????????
				//= if (viewPage.startsWith("noTiles:")) {}
					//viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; 
					
					viewPage = "/WEB-INF/views/" + viewPage.substring(3) + ".jsp";
					
				} else {
					viewPage = viewPage + ".tiles"; // tiles layout ??????
				}
				System.out.println("tiles viewPage: " + viewPage);
				System.out.println("---------------------------------");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect(viewPage); //.do return
		}

	}

}