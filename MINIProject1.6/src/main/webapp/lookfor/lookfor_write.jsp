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
		
	h2, 
	h3{
	
		font-family: 'KCC-Ganpan';
	}
	
.div_center {

}

table {
  border-collapse: collapse;
  margin-bottom: 20px;


}

td {
  padding: 8px;
}

input[type="submit"],
input[type="button"] 
{
  padding:5px 8px;	
  background-color: #FFDDCC;
  color: black;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  margin-right: 10px;
}

input[type="submit"]:hover,
input[type="button"]:hover 
{
  background-color: #E8B9AE;
   color:white;
}

</style>



<div align="center" class="div_center">
	<h3>실종 신고글 작성</h3>
	<hr>

	<form action="writeForm.lookfor" method="post" enctype="multipart/form-data">

		<table border="1" width="700">
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);
	    document.getElementById('currentTime').value = new Date().toISOString().slice(11, 16);
	}
</script>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="10"></td>
				<td>작성자</td>
				<td><input type="text" name="id" size="10"  value="${uvo.id }"
						readonly="readonly"></td>
			</tr>

			<tr>
				<td width="20%">잃어버린 시간</td>
				<td width="80%"><input type="date" name="date" id="currentDate"><input
					type="time" name="time" id="currentTime"></td>


			<td width="20%">신고자 연락처</td>
				<td width="30%"><input type="text" name="phone" value="${uvo.phone }"></td>
			</tr>

	

	

		
			<tr>
				<td>동물 종류</td>
				<td><input type='radio' name='anymal' value='dog' /> 개 <input
					type='radio' name='anymal' value='cat' /> 고양이 <input type='radio'
					name='anymal' value='no' /> 기타</td>

				<td>잃어버린 장소</td>
				<td><input type="text" name="area"></td>
			</tr>

			<tr>
				<td width="20%">내용</td>
				<td colspan="3" height="120px"><textarea rows="10"
						style="width: 95%;" name="content"></textarea></td>
			</tr>

			<tr>
	<td colspan="2"><input type="submit" value="작성 완료" >
					&nbsp;&nbsp; <input type="button" value="목록" onclick="location.href='find_list.find'"></td>
				<td colspan="3"><input type="file" name="fileName"></td>
			</tr>

		</table>
		
	
	</form>

</div>
<%@include file = "../include/footer.jsp"%>