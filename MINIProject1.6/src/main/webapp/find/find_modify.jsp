<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp"%>    
<div align="center" class="div_center">
	<h3>게시판 글 수정</h3>
	<hr>

	<form action="find_update.find" method="post">

		<table border="1" width="700">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="10" value=${vo.title }></td>
				<td>작성자</td>
				<td><input type="text" name="id" size="10"  value="${vo.id }"
						readonly="readonly"></td>

			<input type="hidden" name="num" value="${vo.num }">

			</tr>
			<tr>
				<td>발견 시간</td>
				<td width="300"><input type="date" name="date"><input
					type="time" name="time"></td>
				<td width="20%">신고자 연락처</td>
				<td width="30%"><input type="text" name="ph" value="${vo.ph }"></td>
			</tr>
			<tr>
				<td>동물 종류</td>
				<td><input type='radio' name='anymal' value='dog' ${vo.type == 'dog' ? 'checked' : '' }> 개 
					<input type='radio' name='anymal' value='cat' ${vo.type == 'cat' ? 'checked' : '' }> 고양이 
					<input type='radio' name='anymal' value='no' ${vo.type == 'no' ? 'checked' : '' }/> 기타
					</td>

				<td>발견 장소</td>
				<td><input type="text" name="area" value="${vo.area }"></td>

			</tr>

			<tr>
				<td width="20%">내용</td>
				<td colspan="3" height="120px"><textarea rows="10"
						style="width: 95%;" name="content" value=${vo.content}>${vo.content }</textarea></td>
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

<%@include file = "../include/footer.jsp"%>