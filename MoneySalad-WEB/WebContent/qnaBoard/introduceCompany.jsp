	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/na/include/lib/topLibs.jsp"></jsp:include>
        <title>MoneySalad - 돈 관리가 쉬워지는</title>
<!--         <script type="text/javascript" -->
<!--         	src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=4876ba7f5d13b2248111d87ea23ed4a3"></script> -->
        	<script>
        	new WOW().init();
        	
        	
//         	$(document).ready(function() {

//         		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
//         		var options = { //지도를 생성할 때 필요한 기본 옵션
//         			center : new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
//         			level : 3
//         		//지도의 레벨(확대, 축소 정도)
//         		};
        		
//         		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        		
//         		$("#kopo").click(function() {
        			
//         			 options = { //지도를 생성할 때 필요한 기본 옵션
//         						center : new kakao.maps.LatLng(37.477436, 126.862565), //지도의 중심좌표.
//         						level : 3
//         					//지도의 레벨(확대, 축소 정도)
//         					};
        					
//         					var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        			
//         		})
//         	})
        	
        </script>
    </head>
    <body class="sb-nav-fixed">
    	<jsp:include page="/na/include/layout/topnav.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="/na/include/layout/sidenav.jsp"></jsp:include>
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">머니샐러드</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">회사소개</li>
                        </ol>
                        
            <h2>머니샐러드</h2>
			<hr>
			<br>
			<h4>회사위치</h4>
		<div id="map" style="width:40%;height:200px;"></div>
		<div>회사이름: 머니샐러드(MoneySalad)</div>
		<div>주소: 경기 광명시 오리로 904</div>
		<div>전화번호: 031-404-5000</div>
		<div>이메일: 2060340014@kopo.ac.kr</div>
		<div>FAX: 031-404-5000</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4876ba7f5d13b2248111d87ea23ed4a3"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.477436, 126.862565), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(37.477436, 126.862565); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>
		</div>	
                </main>
                	<jsp:include page="/na/include/layout/footer.jsp"></jsp:include>
                
            </div>
        </div>
	<jsp:include page="/na/include/lib/bottomLibs.jsp"></jsp:include>
	<script>
        
//         	var userVO = '<c:out value="${userVO}"/>';
     
//         	if(userVO == "") {
//         	Swal.fire({
//         		  icon: 'error',
//         		  title: 'Oops...',
//         		  text: '로그인이 필요한 서비스입니다.'
        		 
//         		}).then((result) => {
<%--         			location.href="<%=request.getContextPath()%>/login.do" --%>
//         				})
//         }
        
        </script>

</body>
</html>




