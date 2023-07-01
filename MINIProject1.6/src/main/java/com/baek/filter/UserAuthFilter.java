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

@WebFilter({"/user/user_mypage.user",//마이페이지
	"/user/user_modify.user",
	"/user/user_board.user",//정보 수정페이지
	"/find/find_writer.find",//글등록페이지
	"/board/registForm.board"})//글등록 요청 페이지//urlPatterns줄여서 쓸 수 있음
public class UserAuthFilter implements Filter{

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException {

//상위 버전이라 하위버전인 http서블릿으로 캐스팅해준다.
HttpServletRequest req = (HttpServletRequest)request;
HttpServletResponse res = (HttpServletResponse)response;
//세션얻기
HttpSession session=req.getSession();
//회원이 로그인 할 때 저장한 인증값
String user_id=(String)session.getAttribute("user_id");
//#1 로그인이 안됐을때

if(user_id==null) {//if구문으로 만들었다는 것은 반드시 리턴으로 함수를 종료시켜야됨 빠지면 심각한 에러 뜸!!!!
	String path = req.getContextPath()+"/user/user_login.user";
	
	//res.sendRedirect(path);
	res.setContentType("text/html; charset=utf-8");
	PrintWriter out= res.getWriter();
	out.println("<script>");
	out.println("alert('로그인이 필요한 서비스');");
	out.println("location.href='"+ path+"';");
	out.println("</script>");
	
	return;//필터종료
}
//다음 코드를 실행함 or 필터를 실행함
chain.doFilter(request, response);
}

}

