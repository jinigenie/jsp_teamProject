<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp"%>
<style>

	
	@font-face {
    font-family: 'KCC-Ganpan';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCC-Ganpan.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
		
	h3{
	
		font-family: 'KCC-Ganpan';
	}
	

form {
  width: 330px;
  margin: 0 auto;
  padding: 20px;
  padding-top: 30px;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  
}



input[type="text"],
input[type="password"] {
  width: 70%;
  padding: 5px;
 	float:right;
  border: 1px solid #ccc;
  border-radius: 3px;
  margin-right: 10px;
  transform : translateY(-3px);
  
}



input[type="submit"],
input[type="button"] {
  padding: 8px 30px 8px 30px  ;
  background-color:#FFF0D8;
  color: black;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

input[type="submit"]:hover,
input[type="button"]:hover {
   background-color:#FFDDCC ;
}



</style>

	<section>
		<div align="center">
			<h3>로그인</h3>
			<form action="loginForm.user" method="post">
				<span>아이디</span>	<input type="text" name="id" placeholder="아이디"><br>	<br>
				<span>비밀번호</span>	<input type="password" name="pw" placeholder="비밀번호"><br> <br><br>
				<input type="submit" value="로그인"> 
				<input type="button" value="가입하기" onclick="location.href='user_join.user'">
			</form>
			<div>${msg }</div>
		</div>
	</section>
<%@include file = "../include/footer.jsp"%>
