<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>


<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>품으로 안아주개</title>
	
    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	<!-- jQuery -->
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>
	<style>
	
	@font-face {
    font-family: 'KCC-Ganpan';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCC-Ganpan.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
	
	body{
	
		font-family: 'KCC-Ganpan';
	}
	
	.abc {
		position: sticky;
		top: 0px;
		width: 100%; 
		z-index: 10;
	}
	.brand{
   justify-content:center;
   align-item: center;
   
   }
	
	</style>
    
    
</head>

<body>
	<!-- header -->
	<div class="brand"><a href="<%=request.getContextPath() %>/index.jsp"><img src="<%=request.getContextPath() %>/img/logo.png" alt="로고" width="400px"> </a></div>        
   <!--  <div class="address-bar">Welcome to MyWorld</div> -->
    
    <nav class="navbar navbar-default abc" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">품으로 안아주개</a>
            </div>
           
           
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	
                    <li>
                        <a href="<%= request.getContextPath()%>/index.jsp">홈화면</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath()%>/lookfor/lookfor_list.lookfor">실종신고</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/find/find_list.find">발견신고</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/site/site.site">유기견 보호센터</a>
                    </li>
                    
                    
                   <c:choose>
                   		<c:when test="${sessionScope.user_id != null }">
	                   		<li>
	                        	<a href="<%=request.getContextPath()%>/user/user_mypage.user">나의 정보 관리</a>
	                 	    </li>
	                 	    <li>
	                       		<a href="<%= request.getContextPath()%>/user/user_logout.user" style="color:red">로그아웃</a>
	                  		</li>
                   		</c:when>
                   		
                   		<c:otherwise>
		                    <li>
		                        <a href="<%=request.getContextPath()%>/user/user_login.user">LOGIN</a>
		                    </li>
		                    <li>
		                        <a href="<%= request.getContextPath()%>/user/user_join.user" >JOIN</a>
		                    </li>
                   		</c:otherwise>
     
                    </c:choose>
                    
                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
   

</body>
 	<!-- end header -->
