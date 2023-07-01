package com.baek.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baek.find.service.FindService;
import com.baek.find.service.FindServicelmpl;
import com.baek.user.service.UserService;
import com.baek.user.service.UserServicelmpl;
import com.mini.lookfor.service.LookForService;
import com.mini.lookfor.service.LookForServiceImpl;

/**
 * Servlet implementation class siteController
 */
@WebServlet("*.site")
public class siteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public siteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	//2. get/post하나로 모은다
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//3. 요청분기
		//한글처리
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		//uri의 주소만 자르고 각 요청 비교
		String command=uri.substring(conPath.length());
		FindService service = new FindServicelmpl(); 
		LookForService servicelk=new LookForServiceImpl();
		UserService ser=new UserServicelmpl();
		HttpSession session=request.getSession();
	
		if(command.equals("/site/site.site")) {
			
			String sd=request.getParameter("searchField");
			System.out.println(sd+"oiasodjiasjdpjsd;lamd");
			request.setAttribute("sd", sd);
			
			
			request.getRequestDispatcher("site.jsp").forward(request, response);

		}
	
	}
	
	
}
