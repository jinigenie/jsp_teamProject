
package com.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.find.service.FindService;
import com.baek.find.service.FindServicelmpl;
import com.baek.findcomment.model.FindReplyDAO;
import com.baek.findcomment.model.FindReplyVO;
import com.baek.findreply.service.FindReplyService;
import com.baek.findreply.service.FindReplyServicelmpl;
import com.baek.lookforreply.service.LookforReplyService;
import com.baek.lookforreply.service.LookforReplyServicelmpl;

@WebServlet("*.LKreply")
public class LKReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LKReplyController() {
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
		LookforReplyService service = new LookforReplyServicelmpl(); 
		
		
		//댓글 등록하면 insert해주기
		if(command.equals("/lookfor/reply.LKreply")) {
			
			
			int content_num = Integer.parseInt(request.getParameter("content_num"));
			System.out.println(content_num);
			service.addComment(request,response);
			
			
			//등록하고 다시 게시글 보기로 가는데 게시글 번호가 있는 게시글 보기로 이동하기
			response.sendRedirect("lookfor_content.lookfor?num="+content_num);
			
		}else if(command.equals("/lookfor/lookforreply_del.LKreply")) {
			
			int content_num = Integer.parseInt(request.getParameter("num"));
			service.addComment(request,response);
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 삭제 성공')");
			out.println("location.href='lookfor_content.lookfor?num="+content_num+"';");
			out.println("</script>");
			service.del(request,response);
			
		}
	}

}
