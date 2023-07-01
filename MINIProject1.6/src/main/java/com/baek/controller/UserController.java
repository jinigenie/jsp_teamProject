package com.baek.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baek.find.model.FindVO;
import com.baek.find.service.FindService;
import com.baek.find.service.FindServicelmpl;
import com.baek.findcomment.model.FindReplyVO;
import com.baek.findreply.service.FindReplyService;
import com.baek.findreply.service.FindReplyServicelmpl;
import com.baek.lookforcomment.model.LookforReplyVO;
import com.baek.lookforreply.service.LookforReplyService;
import com.baek.lookforreply.service.LookforReplyServicelmpl;
import com.baek.user.model.UserVO;
import com.baek.user.service.UserService;
import com.baek.user.service.UserServicelmpl;
import com.mini.lookfor.model.LookForVO;
import com.mini.lookfor.service.LookForService;
import com.mini.lookfor.service.LookForServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
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
		if(command.equals("/user/user_join.user")) {

			request.getRequestDispatcher("user_join.jsp").forward(request, response);

		}else if(command.equals("/user/joinForm.user")) {

			int result=ser.join(request, response);
			if(result==1) {
				//중복
				//msg 1회성으로 사용 request.setAttribute로
				request.setAttribute("msg","중복된 아이디 입니다");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);
				//msg의 값을 갖고가야 하기 때문에 forward를 사용
			}else {
				//가입성공
				response.sendRedirect("user_login.user");
			}
		}

		else if(command.equals("/user/user_login.user")) {

			request.getRequestDispatcher("user_login.jsp").forward(request, response);

		}else if(command.equals("/user/loginForm.user")) {
			UserVO vo =ser.login(request, response);

			if(vo==null) {//로그인 실패
				request.setAttribute("msg", "아이디 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
			}else {//로그인 성공
				//세션에 회원정보 저장
				//현재 세션의 정보를 반환해준다.
				//중요!!!!

				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_pw", vo.getId());
				session.setAttribute("user_phone", vo.getPhone());

				response.sendRedirect("user_mypage.user");


			}


		}else if(command.equals("/user/user_mypage.user")) {
			//			if(session.getAttribute("user_id")==null) {
			//			response.sendRedirect("user_login.user");
			//			return;
			//		}
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);


		}else if(command.equals("/user/user_logout.user")) {


			session.invalidate();
			response.sendRedirect("user_login.user");

		}else if(command.equals("/user/user_modify.user")) {

			

			UserVO vo=ser.getInfo(request, response);
			
			
			request.setAttribute("vo", vo);

			request.getRequestDispatcher("user_modify.jsp").forward(request, response);

		}else if(command.equals("/user/user_bye.user")) {
			
			request.getRequestDispatcher("user_delete.jsp").forward(request, response);
			
		}else if(command.equals("/user/user_del.user")) {
			
			int result=ser.del(request, response);
			if(result==1) {
				session.invalidate();
				response.setContentType("text/html; charset=utf-8;");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('회원 탈퇴 성공~')");
				out.println("location.href='user_login.user';");
				out.println("</script>");
			}else {
					response.setContentType("text/html; charset=utf-8;");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('비밀번호가 다릅니다')");
					out.println("history.go(-1);");
					out.println("</script>");
			}
			
			
		}else if(command.equals("/user/user_update.user")) {
			
			int result=ser.updateInfo(request, response);
			if(result==1) {//성공시 (유저이름 변경)
				//out객체를 이용한 메세지 전달
				
//				response.sendRedirect("user_mypage.user");
				response.setContentType("text/html; charset=utf-8;");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보 수정에 성공하였습니다.')");
				out.println("location.href='user_mypage.user';");
				out.println("</script>");
			}else {
				System.out.println("1");
				response.sendRedirect("user_modify.user");
			}
			

		}else if(command.equals("/user/user_board.user")) {
			FindReplyService sv = new FindReplyServicelmpl(); 
			List<FindReplyVO> idlistcomment= sv.idlistComment(request, response);
			
			request.setAttribute("idlistcomment", idlistcomment);
			LookforReplyService sv1 = new LookforReplyServicelmpl(); 
			List<LookforReplyVO> idlistcommentlk= sv1.idlistComment(request, response);
			
			request.setAttribute("idlistcommentlk", idlistcommentlk);
			
			
			
			List<FindVO>vo1=service.getidList(request, response);
			List<LookForVO>vo2=servicelk.getidList(request, response);
			request.setAttribute("vo1", vo1);
			request.setAttribute("vo2", vo2);
			
			request.getRequestDispatcher("user_board.jsp").forward(request, response);
			
		}

	}
}
