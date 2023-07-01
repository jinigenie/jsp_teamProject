<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>


<div class="container">

	<div class="row ">


		<div class="box">


			<div class="col-lg-6 text-center">
				<h2>내 발견신고 게시글</h2>
				<hr>


				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- data-ride="carousel" 자동 슬라이드 기능 -->

					<table class="table table-bordered" width="500">
						<thead>
							<tr>
								<th>순서</th>
								<th>작성자</th>
								<th>제목</th>
								<th>발견 날짜</th>
								<th>발견 지역</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vo" items="${vo1 }" varStatus="x">
								<tr>
									<td>${x.count }</td>
									<td>${vo.id }</td>
									<td><a
										href="<%=request.getContextPath() %>/find/find_content.find?num=${vo.num }">${vo.title }</a></td>
									<td><fmt:parseDate var="B" value="${vo.time }"
											pattern="yyyy-MM-dd HH:mm" /> <fmt:formatDate value="${B }"
											pattern="yyyy-MM-dd (E) hh시mm분" /></td>
									<td>${vo.area}</td>
								</tr>
							</c:forEach>
						</tbody>

						<tbody>
							<tr>
								<td colspan="6" align="right">
									<form action="" class="form-inline">
										<div class="form-group">
											<input type="text" name="search" placeholder="제목검색"
												class="form-control"> <input type="submit"
												value="검색" class="btn btn-default"> <input
												type="button" value="글 작성" class="btn btn-default"
												onclick="location.href='<%=request.getContextPath()%>/find/find_writer.find'">
										</div>
									</form>
								</td>
							</tr>
						</tbody>

					</table>
				</div>

			</div>

			<div class="col-lg-6 text-center">
				<h2>내 실종신고 게시글</h2>
				<hr>



				<table class="table table-bordered">
					<thead>
						<tr>
							<th>순서</th>
							<th>글 번호</th>
							<th>작성자</th>
							<th>제목</th>
							<th>실종 날짜</th>
							<th>실종 지역</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="vo" items="${vo2 }" varStatus="x">
							<tr>
								<td>${x.count }</td>
								<td>${vo.num }</td>
								<td>${vo.id }</td>
								<td><a href="<%=request.getContextPath() %>/lookfor/lookfor_content.lookfor?num=${vo.num }">${vo.title }</a></td>
								<td><fmt:parseDate var="B" value="${vo.time }"
										pattern="yyyy-MM-dd HH:mm" /> <fmt:formatDate value="${B }"
										pattern="yyyy-MM-dd (E) hh시mm분" /></td>
								<td>${vo.area}</td>
							</tr>
						</c:forEach>
					</tbody>

					<tbody>
						<tr>
							<td colspan="6" align="right">
								<form action="" class="form-inline">
									<div class="form-group">
										<input type="text" name="search" placeholder="제목검색"
											class="form-control"> <input type="submit" value="검색"
											class="btn btn-default"> <input type="button"
											value="글 작성" class="btn btn-default"
											onclick="location.href='<%=request.getContextPath()%>/lookfor/lookfor_write.lookfor'">
									</div>
								</form>
							</td>
						</tr>
					</tbody>

				</table>

			</div>



		</div>


<div class="row">
			<div class="box">

				<div class="col-lg-6 text-center">
					<hr>
					<h2 class="intro-text text-center">
						<strong>내 발견 신고 게시판 댓글</strong>
					</h2>
					<hr>
					<div class="inner" align="center">
						<!-- img-border -->

						<hr class="visible-xs">

						<c:forEach items="${idlistcomment }" var="reply">
							<div>
								본문 게시글 번호 : ${reply.parentidx }
								<a href="<%=request.getContextPath()%>/find/find_content.find?num=${reply.parentidx }">댓글 내용 : [${reply.body }]</a> <br /> 
								작성 시간 : <fmt:formatDate value="${reply.regdate }" pattern="yyyy-MM-dd (E) hh시mm분" /><br />
						
							</div>
							<hr>
						</c:forEach>
					</div>


				</div>
<div class="col-lg-6 text-center">
					<hr>
					<h2 class="intro-text text-center">
						<strong>내 실종 신고 게시판 댓글</strong>
					</h2>
					<hr>
					<div class="inner" align="center">
						<!-- img-border -->

						<hr class="visible-xs">

						<c:forEach items="${idlistcommentlk }" var="lkreply">
							<div>
								본문 게시글 번호 : ${lkreply.parentidx } 
								<a href="<%=request.getContextPath()%>/lookfor/lookfor_content.lookfor?num=${lkreply.parentidx }">댓글 내용 : [${lkreply.body }]</a> <br /> 
								작성 시간 : <fmt:formatDate value="${lkreply.regdate }" pattern="yyyy-MM-dd (E) hh시mm분" /><br />
						
							</div>
							<hr>
						</c:forEach>
					</div>


				</div>



			</div>
		</div>

		<!-- /.container -->
	</div>
</div>



<%@include file="../include/footer.jsp"%>