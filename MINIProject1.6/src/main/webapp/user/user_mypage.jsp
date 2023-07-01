<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp"%>
 <section>
    
    <div align="center">
    	<h3>회원 정보 페이지</h3>
    	${sessionScope.user_id }님의 정보를 관리중입니다.
    	<hr>
    	<a href="user_modify.user">회원 수정</a>
    	<hr>
    	<a href="user_board.user">내가 쓴 글 보기</a>
    	<hr>
    	<a href="user_logout.user">로그아웃</a>
    	<hr>
    	<a href="user_bye.user">회원 탈퇴</a>
    	<hr>
    	
    </div>
    

    
    </section>
<%@include file = "../include/footer.jsp"%>