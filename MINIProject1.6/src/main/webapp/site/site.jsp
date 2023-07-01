<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<style>
@font-face {
   font-family: 'KCC-Ganpan';
   src:
      url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCC-Ganpan.woff2')
      format('woff2');
   font-weight: normal;
   font-style: normal;
}

h3 {
   font-family: 'KCC-Ganpan';
}

.area {
   display: flex;
}

.form-control {
   width: 300px;
   margin-right: 5px;
}

.areab {
   margin-right: 10px;
   display: flex;
   height: 33px;
   border: 1px;
   background-color: #FFDDCC;
}
.table{
width: 300px;
margin-left: 100px;
}
</style>

<div align="center" class="container" width="700">

            <h3>동물 보호 센터 검색</h3><br><br>

<div class="col-lg-6 text-center">
<table class="table">
   <div align="center" class="container" width="700">
         <FORM action="site.site" method="post">
         <div class="area" >

            
               <tr>
               <td><select class="form-control" name="searchField">
                  <option value="0">선택</option>
                  <option value="1">서초 동물 사랑 센터</option>
                  <option value="2">팅커벨 입양 센터</option>
                  <option value="4">고양시 동물 보호 센터</option>
                  <option value="5">아이조아요양보호소 강남점</option>
                  <option value="6">평택시 유기동물 보호소</option>
               
               </select></td>
               <td><input type="submit" class="areab" value="찾기"></td></tr>
               </FORM>
               <c:if test="${sd == 1 }">
               <table class="table">
               <tr><td>
               <a href="https://www.seocho.go.kr/site/animal/main.do">서초 동물 사랑 센터</a>
               </td></tr>
               <tr><td>
               위치 : 서울특별시 서초구 양재1동 양재천로19길 22
               </td></tr>
               <tr><td>
               전화번호 : 
               </td></tr>
               </table>
               </c:if>
               <c:if test="${sd == 2 }">
               <table class="table">
               <tr><td>
               <a href="http://m.tinkerbellproject.or.kr/">팅커벨 입양 센터</a>
               </td></tr>
               <tr><td>
               위치 : 서울특별시 강서구 곰달래로 255
               </td></tr>
               <tr><td>
               전화번호 : 02-2647-8255
               </td></tr>
               </table>
               </c:if>
               
               <c:if test="${sd == 4 }">
               <table class="table">
               <tr><td>
               <a href="https://m.cafe.daum.net/goyanganimal/_rec">고양시 동물 보호 센터</a>
               </td></tr>
               <tr><td>
               위치 : 경기도 고양시 덕양구 고양대로 1695
               </td></tr>
               <tr><td>
               전화번호 : 01046344879
               </td></tr>
               </table>
               </c:if>
               <c:if test="${sd == 5 }">
               <table class="table">
               <tr><td>
               <a href="https://www.ijoa.co.kr/">아이조아요양보호소 강남점</a>
               </td></tr>
               <tr><td>
               위치 : 서울특별시 강남구 봉은사로47길 59, B1
               </td></tr>
               <tr><td>
               전화번호 : 0220602488
               </td></tr>
               </table>
               </c:if>
               <c:if test="${sd == 6 }">
               <table class="table">
               <tr><td>
               <a href="https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=joorecipe&logNo=221069660990">평택시 유기동물 보호소</a>
               </td></tr>
               <tr><td>
               위치 : 경기도 평택시 야막길 108-86
               </td></tr>
               <tr><td>
               전화번호 : 031-8024-3849
               </td></tr>
               </table>
               </c:if>
               
               </table>
</div>         
   
   <div class="col-lg-6 text-center">   
   <table class="table table-bordered">
      <c:if test="${sd == 1 }"> 
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d147355.15355820992!2d126.87900613252519!3d37.54506874050658!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca10b5d836675%3A0x1bbfbc48b01835de!2z7ISc7LSIIOuPmeusvOyCrOuekeyEvO2EsA!5e0!3m2!1sko!2skr!4v1686671138676!5m2!1sko!2skr"
         width="700" height="400" style="border: 0;" allowfullscreen=""
         loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe></c:if>
      <c:if test="${sd == 2 }"> 
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d101246.94315366862!2d126.70886949726561!3d37.5322758!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9c2ee75ab4f7%3A0x6c8ddbffefe5220!2z7YyF7Luk67Ko7J6F7JaR7IS87YSw!5e0!3m2!1sko!2skr!4v1686713020741!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
      </c:if>
      
      <c:if test="${sd == 4 }"> 
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d101088.28140094869!2d126.7176551972656!3d37.64899730000002!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9747ace09e61%3A0x28ca33f31dd7a6ab!2z6rOg7JaR7IucIOuPmeusvOuztO2YuOyEvO2EsA!5e0!3m2!1sko!2skr!4v1686713130568!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
      
      </c:if>
      <c:if test="${sd == 5 }"> 
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d101300.91328991397!2d126.96748642875218!3d37.4925014053521!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca3c7213c54ed%3A0x671eea98208d3157!2z7JWE7J207KGw7JWE7JqU7JaR67O07Zi47IaMIOqwleuCqOygkA!5e0!3m2!1sko!2skr!4v1686718193712!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
      </c:if>
      <c:if test="${sd == 6 }"> 
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d101789.469408612!2d126.9030941972656!3d37.130796400000015!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b3a5e55555555%3A0x90c31f9b8c602a18!2z7Y-J7YOd7Iuc7Jyg6riw64-Z66y867O07Zi47IaM!5e0!3m2!1sko!2skr!4v1686713185190!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
      </c:if>
   </table>
   
      </div>
   
   
   </div>
   </div>
</div>


<%@include file="../include/footer.jsp"%>