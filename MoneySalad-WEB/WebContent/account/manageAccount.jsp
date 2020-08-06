<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/na/include/lib/topLibs.jsp"></jsp:include>
        <title>MoneySalad - 돈 관리가 쉬워지는</title>
        <script>
        	new WOW().init();
        	
        	
                	
        	
        	
        	function doRegister() {

        		let f = document.wForm;

        		if (f.depositAmount.value < 1000) {
        			alert("1,000원 이상의 금액을 입금해주세요.")
        			f.depositAmount.focus()
        			return false
        		}


        		return true;

        	}
        	
        	function goEdit() {
        		location.href="<%=request.getContextPath() %>/editAccountNicknameForm.do"
				
			}
        	function goDelete() {
        		location.href="<%=request.getContextPath() %>/deleteAccountForm.do"
				
			}


        </script>
    </head>
    <body class="sb-nav-fixed">
    	<jsp:include page="/na/include/layout/topnav.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="/na/include/layout/sidenav.jsp"></jsp:include>
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">계좌관리</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">계좌관리</li>
                        </ol>
                        
<!--          <hr width="80%"> -->
		<h2>관리항목 선택</h2>
		<hr width="100%">
		<br>
		<br>
		
		
	<button type="button" onclick="goEdit()" class="btn btn-info btn-group-lg" style="width:20%;  height:100px;"><h3>계좌별칭 수정</h3></button>
  	<button type="button" onclick="goDelete()" class="btn btn-warning  btn-group-lg" style="width:20%;  height:100px;"><h3>계좌 삭제</h3></button>
		
<%-- 		<a href="<%=request.getContextPath() %>/editAccountNicknameForm.do">계좌별칭 수정</a> --%>
<!-- 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<%-- 		<a href="<%=request.getContextPath() %>/deleteAccountForm.do">계좌 삭제</a> --%>
		

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




