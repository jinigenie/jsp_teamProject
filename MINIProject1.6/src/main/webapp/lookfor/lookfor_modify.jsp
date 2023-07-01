<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>

<div align="center" class="div_center">
	<h3>게시판 글 수정</h3>
	<hr>

	<form action="lookfor_update.lookfor" method="post">

		<table border="1" width="600">

			<tr>
				<td width="20%">동물 종류</td>
				<td>
					<input type='radio' name='anymal' value='dog' ${vo.type == 'dog' ? 'checked' : '' }> 개 
					<input type='radio' name='anymal' value='cat' ${vo.type == 'cat' ? 'checked' : '' }> 고양이 
					<input type='radio' name='anymal' value='no' ${vo.type == 'no' ? 'checked' : '' }/> 기타
				</td>
			</tr>

			<tr>
				<td width="20%">잃어버린 시간</td>
				<td width="80%"><input type="date" name="date"><input
					type="time" name="time"></td>

			</tr>

			<tr>
				<td width="20%">잃어버린 장소</td>
				<td width="80%"><input type="text" name="area" value=${vo.area}></td>
			</tr>

		</table>

		<br>

		<table border="1" width="600">

			<tr>
				<input type="hidden" name="num" value="${vo.num }">
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="id" value="${vo.id }" readonly></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td><input type="text" name="title" value=${vo.title }>
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><textarea rows="10" style="width: 95%;" name="content"
						value=${vo.content}>${vo.content }
					</textarea></td>
			</tr>

		</table>
		<table>
		<td align="center" style="padding: 10px 0 10px 0">
			<input type="button" value="돌아가기" onClick="history.go(-1)">&nbsp;
			<input type="submit" value="수정하기" >&nbsp;
			<input type="button" value="목록" onclick="location.href='lookfor_list.lookfor'">&nbsp;
		</td>
		</table>
	</form>

</div>


<%@include file="../include/footer.jsp"%>