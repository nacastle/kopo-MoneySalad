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


        </script>
    </head>
    <body class="sb-nav-fixed">
    	<jsp:include page="/na/include/layout/topnav.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="/na/include/layout/sidenav.jsp"></jsp:include>
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">별칭수정</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/manageAccount.do">계좌관리</a></li>
                            <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/editAccountNicknameForm.do">계좌선택</a></li>
                            <li class="breadcrumb-item active">별칭수정</li>
                        </ol>
                        
<!--          <hr width="80%"> -->
		<h2>별칭수정양식</h2>
		<hr width="100%">
		<br>
		<br>
		<form action="<%=request.getContextPath()%>/editAccountNicknameProcess.do" name="wForm" method="post"
			autocomplete="off" onsubmit="return doRegister()">

			<input type="hidden" name="accountNumber" value="${accountNumber }">
			<table border="1" style="width: 80%">
				<tr>
					<th width="23%">새로운 별칭 입력</th>
					<td><input type="text" name="newNickname" size="20%"></td>
				</tr>

			</table>
			<br>
			<input class="btn btn-outline-primary" style="margin-left: 2%" type="submit" value="수정">

<!-- 			<input type="submit" value="수정"> -->
		</form>
		

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




