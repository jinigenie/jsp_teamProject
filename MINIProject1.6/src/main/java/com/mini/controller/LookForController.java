package com.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@WebServlet("*.lookfor")
public class LookForController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LookForController() {
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
		String command = uri.substring(conPath.length());
		LookforReplyService fservice = new LookforReplyServicelmpl(); 
		LookForService service = new LookForServiceImpl(); 
		UserService u_service = new UserServicelmpl();
		List<LookForVO> list=null;
		// 등록 작업
		if(command.equals("/lookfor/writeForm.lookfor")) {
		
			try {
				service.write(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}

		// 목록 화면 처리
		} else if(command.equals("/lookfor/lookfor_list.lookfor")) {

			list=service.getList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("lookfor_list.jsp").forward(request, response);

		// 게시글 상세 화면
		} else if(command.equals("/lookfor/lookfor_content.lookfor")) {

			LookforReplyService sv = new LookforReplyServicelmpl(); 
			List<LookforReplyVO> listcomment = sv.listComment(request, response);
			
			request.setAttribute("listcomment", listcomment);
			
			LookForVO vo = service.getContent(request, response);
			
			UserVO uvo = u_service.getInfo(request, response);
			
			request.setAttribute("vo", vo);
			request.setAttribute("uvo", uvo);
			request.getRequestDispatcher("lookfor_content.jsp").forward(request, response);

		//글쓰기 화면에 처리
		} else if(command.equals("/lookfor/lookfor_write.lookfor")) {

			UserVO uvo = u_service.getInfo(request, response);
			request.setAttribute("uvo", uvo);
			request.getRequestDispatcher("lookfor_write.jsp").forward(request, response);

		//게시글 수정 화면	
		} else if(command.equals("/lookfor/lookfor_modify.lookfor")) {

			LookForVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("lookfor_modify.jsp").forward(request, response);

		//글 수정	
		} else if(command.equals("/lookfor/lookfor_update.lookfor")) {

			service.update(request, response);
			String num = request.getParameter("num");
			response.sendRedirect("lookfor_content.lookfor?num=" + num);

		//돌아가기	
		} else if(command.equals("/lookfor/lookfor_return.lookfor")) {
			
			service.update(request, response);
			response.sendRedirect("lookfor_content.lookfor");
		
		//게시글 삭제
		} else if(command.equals("/lookfor/lookfor_delete.lookfor")){
			fservice.delete(request, response);
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('게시글을 삭제하였습니다.')");
			out.println("location.href='lookfor_list.lookfor';");
			out.println("</script>");
			service.delete(request, response);
			
			
			
			
			
		//게시글 검색
		}else if(command.equals("/lookfor/lookfor_serch.lookfor")) {

			if(request.getParameter("searchField").equals("o_title")) {
			list=service.getTitle(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("lookfor_list.jsp").forward(request, response);
			}
			else if(request.getParameter("searchField").equals("o_area")) {
			list=service.getArea(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("lookfor_list.jsp").forward(request, response);
			}else {
				response.setContentType("text/html; charset=utf-8;");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('지역 또는 제목을 선택해주세요')");
				out.println("location.href='lookfor_list.lookfor';");
				out.println("</script>");
			}
			//게시글 수정 화면	
		}
		
	}

}
