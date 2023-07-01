<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp"%>
	<div align="center">
		<h2>비밀번호 입력</h2>
		<form action="user_del.user" method="post">

			<input type="password" name="pw"/><br>
			<input type = "submit" value="삭제">
			<input type="button" value="회원페이지로 가기" onclick="location.href='user_mypage.user'">
		</form>
	</div>

<%@include file = "../include/footer.jsp"%>
