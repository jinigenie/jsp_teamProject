package com.baek.controller;

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
import com.baek.findreply.service.FindReplyService;
import com.baek.findreply.service.FindReplyServicelmpl;
import com.baek.user.model.UserVO;
import com.baek.user.service.UserService;
import com.baek.user.service.UserServicelmpl;
import com.mini.lookfor.model.LookForVO;

@WebServlet("*.find")
public class FindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindController() {
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
		UserService ser=new UserServicelmpl();
		FindService service = new FindServicelmpl(); 
		FindReplyService fservice = new FindReplyServicelmpl(); 

		List<FindVO>list=null;
		if(command.equals("/find/writerForm.find")) {
			System.out.println(request.getParameter("area"));
			System.out.println(request.getParameter("title"));
			try {
				service.writer(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
			
		}else if(command.equals("/find/find_list.find")) {

			list=service.getList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("find_list.jsp").forward(request, response);
			//			request.getRequestDispatcher("board_list.jsp").forward(request, response);

		}else if(command.equals("/find/find_writer.find")) {
			UserVO vo=ser.getInfo(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("find_writer.jsp").forward(request, response);

			//게시글 수정 화면	
		}else if(command.equals("/find/find_content.find")) {


			//화면 나타낼때 댓글 테이블도 리스트로 생성해서 같이 출력 (이떄 리스트 불러오는 기준은 게시글 번호로)
			FindReplyService sv = new FindReplyServicelmpl(); 
			List<FindReplyVO> listcomment= sv.listComment(request, response);
			
			request.setAttribute("listcomment", listcomment);
			
			FindVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("find_content.jsp").forward(request, response);



		}else if(command.equals("/find/find_serch.find")) {

			if(request.getParameter("searchField").equals("o_title")) {
			list=service.getTitle(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("find_list.jsp").forward(request, response);
			}else if(request.getParameter("searchField").equals("o_area")) {
			list=service.getArea(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("find_list.jsp").forward(request, response);
			}else {
				response.setContentType("text/html; charset=utf-8;");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('지역 또는 제목을 선택해주세요')");
				out.println("location.href='find_list.find';");
				out.println("</script>");
			}
			//게시글 수정 화면	
		}else if(command.equals("/find/find_modify.find")) {

			FindVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("find_modify.jsp").forward(request, response);

		//글 수정	
		}  else if(command.equals("/find/find_update.find")) {
			
			service.update(request, response);
			String num = request.getParameter("num");
			response.sendRedirect("find_content.find?num=" + num);

		//돌아가기	
		}else if(command.equals("/find/find_delete.find")){
			
			fservice.delete(request, response);
			service.delete(request, response);
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('게시글을 삭제하였습니다.')");
			out.println("location.href='find_list.find';");
			out.println("</script>");
			
			
			
			
		//게시글 검색
		}
	}

}
