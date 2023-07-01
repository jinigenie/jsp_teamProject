package com.baek.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//본인이 작성한 글만, 수정 삭제를 할 수 있다.
@WebFilter({"/find/find_modify.find",
			"/lookfor/lookfor_modify.lookfor",//글 작성페이지
			//글수정 and 삭제기능
})
public class boardAuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpServletRequest req= (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//작성자를 구함
		String writer = request.getParameter("writer");
		System.out.println(writer+"dpd???");
		//세션에 저장된 작성자
		HttpSession session = req.getSession();
		String user_id=(String)session.getAttribute("user_id");
		
		String path = req.getContextPath()+"/user/user_login.user";
		if(writer==null ||user_id==null) {//둘 중 하나가 null이면 에러
			//res.sendRedirect(path);
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out= res.getWriter();
			out.println("<script>");
			out.println("alert('허용하지 않는 접근입니다.');");
			out.println("history.go(-1)");
			out.println("</script>");
			
			return;//필터종료
			
		}
		//작성자와 세션이 같지 않은 경우
		if(!writer.equals(user_id)) {
			
			//res.sendRedirect(path);
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out= res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("history.go(-1)");
			out.println("</script>");
			
			return;//필터종료
			
			
		}
		
		
		chain.doFilter(request, response);
	}

}
