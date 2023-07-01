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
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

table {
  margin-bottom: 20px;
}

td {
  padding: 5px;
}


input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

input[type="submit"],
input[type="reset"] {


  padding: 8px 30px 8px 30px  ;
  background-color:#FFF0D8;
  color: black;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

input[type="submit"]:hover,
input[type="reset"]:hover {
  background-color:#FFDDCC ;
}

</style>
<section>


	<div align="center"><!-- 문자를 가운데로 -->
	
	<h3>회원가입</h3>
	
		<form action="joinForm.user" method="post">
			<table>
			
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" required="required" pattern="\w{3,}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" required="required" pattern="\w{4,}"></td>
				</tr>
				<tr>
					<td>핸드폰 번호</td>
					<td><input type="text" name="phone" required="required" pattern="\w{3,}"></td>
				</tr>
				
			</table>
			
			<div style="color:red;">${msg }</div>
			
			<input type="submit" value="가입">
			<input type="reset" value="정보초기화">
		</form>
	</div>

</section>

<%@include file = "../include/footer.jsp"%>