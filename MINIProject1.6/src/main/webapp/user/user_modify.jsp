<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp"%>

<section>


	<div align="center">
		<!-- 문자를 가운데로 -->
		
		<h3>회원정보 수정</h3>
		
		<%-- <b>${sessionScope.user_id }님의 회원 정보 수정</b> --%>


		<form action="user_update.user" method="post">
			<table border="1">

				<hr>
				<!-- 
				readonly는 태그의 읽기전용
				disabled는 태그의 사용금지 (파라미터값에서 제외됨)
				checked 는 미리 선택함
				required 는 필수로 값을 지정해야되는 기능
				인풋태그에 미리 값을 가지려면 value를 사용
				 -->


				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" placeholder="${vo.id }"
						readonly="readonly"></td>
					<!--readonly="readonly"-읽기전용 disabled="disabled"-이 값은 폼값으로 넘어가지 않는다. -->
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" required="required"
						pattern="\w{4,}"></td>
				</tr>
				<tr>
					<td>핸드폰 번호</td>
					<td><input type="text" name="ph" placeholder="${vo.phone }"></td>
				</tr>
			</table>

			<div style="color: red;">${msg }</div>
			<hr>
			<input type="submit" value="저장"> 
			<input type="button" value="회원페이지로 가기" onclick="location.href='user_mypage.user'">
		<br>
		
		</form>

	</div>




</section>
<%@include file = "../include/footer.jsp"%>