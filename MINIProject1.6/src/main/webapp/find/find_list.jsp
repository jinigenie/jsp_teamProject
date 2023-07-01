<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<div class="container" width="200" align="center">

	<h3>유기동물 발견 신고 게시판</h3>


	<style>
table.table {
	margin: 10px;
	padding: 20px;
	width: 800px;
	overflow: auto;
}

th {
	background-color: #FFDDCC;
}
</style>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>발견 날짜</th>
				<th>발견 지역</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="vo" items="${list }" varStatus="x">
				<tr>
					<td>${x.count }</td>
					<td>${vo.id }</td>
					<td><a href="find_content.find?num=${vo.num }">${vo.title }</a></td>
					<td><fmt:parseDate var="B" value="${vo.time }"
							pattern="yyyy-MM-dd HH:mm" /> <fmt:formatDate value="${B }"
							pattern="yyyy-MM-dd (E) hh시mm분" /></td>
					<td>${vo.area}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<tbody>
		<tr>

			<td colspan="6" align="right">
				<form action="find_serch.find?title=${vo.title }"
					class="form-inline">
					<div class="form-group">
						<tr>
							<td><select class="form-control" name="searchField">
									<option value="0">선택</option>
									<option value="o_title">제목</option>
									<option value="o_area">장소</option>

							</select></td>

							<td><input type="text" name="searchWord" placeholder="제목검색"
								class="form-control"> <input type="submit" value="검색"
								class="btn btn-default"> <input type="button"
								value="글 작성" class="btn btn-default"
								onclick="location.href='find_writer.find'"></td>
						</tr>
					</div>
				</form>
			</td>
		</tr>
	</tbody>


</div>
<%@include file="../include/footer.jsp"%>








