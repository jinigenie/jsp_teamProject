<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file = "../include/header.jsp"%>

<style>

	@font-face {
    font-family: 'KCC-Ganpan';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCC-Ganpan.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
		
 
	h3 , h5{
	
		font-family: 'KCC-Ganpan';
	}
	


table {
        border-collapse: collapse;
        margin-top: 20px;
        width: 700px;
        
    }

    td {
        padding: 10px;
       
    }

    .btn {
        background-color: #FFDDCC;
        color: white;
        border: none;
        padding: 10px 20px;
        font-size: 14px;
        cursor: pointer;
        border-radius: 3px;
    }

	

    #tblListComment {
        width: 600px;
    }

    #tblAddComment {
        width: 600px;
    }

    .form-control {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
    
    
    input[type="submit"],
input[type="reset"] {


  padding: 8px 30px 8px 30px  ;
  background-color:#FFDDCC;
  color: black;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

input[type="submit"]:hover,
input[type="reset"]:hover {
  background-color: ;
   color:white;
  
}
    
    
  input[type="submit"],
input[type="button"] {
  display: inline-block;
  padding: 10px 20px;
  background-color: #FFDDCC;
  color: black;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  margin-right: 10px;
}

input[type="submit"]:hover,
input[type="button"]:hover {
  background-color: #E8B9AE;
   color:white;
}
.card {
  margin: 10px;
  padding: 20px;
  width: 500px;
  overflow: auto;
  
}     
    
</style>



<div align="center" class="div_center">

	<form>
	<h3>잃어버린 아이를 찾습니다!</h3>
	<hr>
	<h5>♡잃어버린 우리 아이를 찾아주시면 반드시 사례하겠습니다!♡</h5>
	
	<!-- <img src=\"/lookfor_file/" + "112" + ".jpg\"> -->
	<!-- <img src="C:\\Users\\user\\Desktop\\course\\jsp\\apache-tomcat-9.0.75\\wtpwebapps\\MINIProject\\lookfor_file\\112.jpg"> -->
	<td><img width="400" height="400" src="<%=request.getContextPath()%>/lookfor_file/${vo.image }"/></td>
	 
	<%System.out.println(request.getContextPath()); %>
	 
	
	
	<table border="1" width="700">

		<tr>
			<td width="20%">글번호</td>
			<td width="25%">${vo.num }</td>

			<td width="20%">연락처</td>
			<td width="35%">${uvo.phone }</td>
		</tr>

		<tr>
			<td width="20%">동물 종류</td>
			<td width="30%">${vo.type }</td>

			<td width="20%">잃어버린 날짜</td>
			<td width="30%"><fmt:parseDate var = "B" value="${vo.time }" pattern="yyyy-MM-dd HH:mm" />
						<fmt:formatDate value="${B }" pattern="yyyy-MM-dd (E) hh시mm분" /></td>
		</tr>
	</table>

	<br>

	<table border="1" width="600">
		<tr>
			<td width="20%">글제목</td>
			<td width="30%">${vo.title }</td>
			<td width="20%">잃어버린 장소</td>
			<td width="30%">${vo.area}</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.content }</td>
		</tr>
	</table>

	<br>

	<div>
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='lookfor_list.lookfor'">&nbsp;&nbsp; 
				<c:if test="${vo.id == sessionScope.user_id }">
				<input type="button" value="수정" onclick="location.href='lookfor_modify.lookfor?num=${vo.num}&writer=${vo.id }'">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="location.href='lookfor_delete.lookfor?num=${vo.num}&writer=${vo.id }'">&nbsp;&nbsp;</td>
			</c:if>
		</tr>
		</div>
		</form>
	</div>
	



	<div align="center">
	<div  class="card" align="right"  >
		<div class="card-header" align="left"><h3>댓글 리스트</h3></div>
	<c:forEach items="${listcomment }" var="reply">
	<fmt:formatDate var = "time" value="${reply.regdate }" pattern="yyyy-MM-dd (E) hh시mm분"/>
		<ul id="reply--box" class="list-group">
		<div class="card1">
			<div><span>작성자 - [${reply.id }]</span></div> 
			<div><span>작성시간 - ${time}</span></div>
		</div>	
			<li id="reply--1" class="list-group-item d-flex justify-content-between">
				<div align="left">${reply.body }</div>
				
				<div class="d-flex">
				<c:if test="${reply.id == sessionScope.user_id }">
					<button  type= "button" class="badge" onclick="location.href='findreply_del.com?idx=${reply.idx}&num=${vo.num }'">삭제</button>
				</c:if>
				<c:if test="${reply.id != sessionScope.user_id }">
					<button  type= "button">삭제</button>
				</c:if>
				</div>
			</li>

		</ul>
			</c:forEach>
	</div>
	<table id="tblAddComment" class="table">
	<tr>
     		<form action="<%=request.getContextPath() %>/lookfor/reply.LKreply" method="post" align="center">
			<input type = "hidden" name= "content_num" value="${vo.num  }" />
			<input type = "hidden" name= "id" value="${user_id  }" />
			<td><textarea name="body" class="form-control" rows="1"  ></textarea></td>
		
			<td align="center"><button type="submit" id="btn-reply-save" class="btn btn-primary">등록</button></td>
</tr>
		</form>
	</table>
	</div>
<%@include file = "../include/footer.jsp"%>