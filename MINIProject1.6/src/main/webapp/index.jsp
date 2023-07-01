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
   
   .col-lg-6 text-center{
      
      justify-content: center;
      align-itmes: center;
      position: absolute;
        top: 50%;
        left: 50%;
        margin: -50px 0 0 -50px;
        
      
   }
   
   </style>
 
    <div class="container">

      <div class="row ">
           
                  
            <div class="box">
                
                     
                <div class="col-lg-6 text-center" >
                  <h2>실종동물을 찾습니다</h2>
               <p>저희 가족을 찾아주세요</p>
               <hr>
               <h3><a href="<%= request.getContextPath()%>/lookfor/lookfor_list.lookfor">둘러보기</a></h3>
               
                   
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"><!-- data-ride="carousel" 자동 슬라이드 기능 -->
                       
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            
                        </ol>

                     
                        <div class="carousel-inner">
                            <div class="item active">
                                  <a href="lookfor/lookfor_content.lookfor?num=1"> <img class="img-responsive img-full" src="img/11.jpg"  ></a>
                            </div>
                            <div class="item">
                                <a href="lookfor/lookfor_content.lookfor?num=2"><img class="img-responsive img-full" src="img/14.jpg"></a> <!-- img-full 옵션 class -->
                            </div>
                            <div class="item">
                                 <a href="lookfor/lookfor_content.lookfor?num=3">  <img class="img-responsive img-full" src="img/12.jpg"></a>
                            </div>
                           
                        </div>

                          
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>
                        
                </div>
                <div class="col-lg-6 text-center">
                  <h2 >보호하고 있습니다</h2>
               <p>가족이 기다리고 있어요</p>
               <hr>
               <h3><a href="<%=request.getContextPath()%>/find/find_list.find">둘러보기</a></h3>
               
                   
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"><!-- data-ride="carousel" 자동 슬라이드 기능 -->
                       
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            
                        </ol>

                     
                        <div class="carousel-inner">
                            <div class="item active">
                                  <a href="#"> <img class="img-responsive img-full" src="img/4.jpg"></a>
                            </div>
                            <div class="item">
                                <a href="#"><img class="img-responsive img-full" src="img/5.jpg"></a> <!-- img-full 옵션 class -->
                            </div>
                            <div class="item">
                                 <a href="#">  <img class="img-responsive img-full" src="img/6.jpg"></a>
                            </div>
                           
                        </div>

                          
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>
                        
                </div>     
             
                <div class="col-lg-6 text-center" style= "margin-left : 250px">    
                    
                  <h2 style = "margin-top: 70px">TIP</h2>
                  <p>
                     반려견 실종 시 대처 방법
                  </p>
                  <hr>
                  <h3>찾고싶은 우리가족</h3>
<iframe width="560" height="315" src="https://www.youtube.com/embed/XMsDXtFWJ2U" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>                </div>   
                    
                
            </div>
            
          
            
        </div>

         
    <!-- /.container -->
    </div>

<%@ include file ="../include/footer.jsp" %>   