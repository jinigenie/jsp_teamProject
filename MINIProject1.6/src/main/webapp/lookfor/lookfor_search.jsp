<%@page import="com.mini.lookfor.service.LookForServiceImpl"%>
<%@page import="com.mini.lookfor.service.LookForService"%>
<%@page import="com.mini.lookfor.model.LookForVO"%>
<%@page import="java.util.List"%>
<%@page import="com.mini.lookfor.model.LookForDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file = "../include/header.jsp"%>
<div align="center" class="container">

	<h3>유기동물 실종 신고 게시판</h3>


	<table border="1" width="600">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>실종 날짜</th>
				<th>실종 장소</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${list.size() == 0 }">
					<script>
						alert("검색결과가 없습니다");
					</script>
				</c:when>
			</c:choose>
			
			<c:forEach var="vo" items="${list }" varStatus="x">
				<tr>
					<td>${vo.num }</td>
					<td><a href="lookfor_content.lookfor?num=${vo.num }">${vo.title }</a></td>
					<td><fmt:parseDate var="B" value="${vo.time }"
							pattern="yyyy-MM-dd HH:mm" /> <fmt:formatDate value="${B }"
							pattern="yyyy-MM-dd (E) hh시mm분" /></td>
					<td>${vo.area}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<br>
		<tr>
			<td colspan="4" align="center">
			<input type="button" value="목록" onclick="location.href='lookfor_list.lookfor'">&nbsp;&nbsp;
			</td>
		</tr>

</div>

<%@include file = "../include/footer.jsp"%>







