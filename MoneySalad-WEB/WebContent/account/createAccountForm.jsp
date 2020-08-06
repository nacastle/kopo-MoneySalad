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
                        <h1 class="mt-4">캐슬계좌 생성</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">캐슬계좌 생성</li>
                        </ol>
                        
<!--          <hr width="80%"> -->
		<h2>계좌생성양식</h2>
		<hr width="100%">
		<br>
		<h4 class="text-primary"><i>${userVO.name }님의 새롭게 생성될 캐슬은행 계좌의 계좌번호는 "${newAccountNumber }" 입니다.</i></h4>
		
		
		<br>
		<form action="<%=request.getContextPath()%>/createAccountProcess.do" name="wForm" method="post"
			autocomplete="off" onsubmit="return doRegister()">

			<input type="hidden" name="newAccountNumber" value="${newAccountNumber }">
			<table border="1" style="width: 80%">
				<tr>
					<th width="23%">별칭 입력</th>
					<td><input type="text" name="nickname" size="20%"></td>
				</tr>
				<tr>
					<th>입금할 금액</th>
					<td><input type="number" name="depositAmount" size="10%">원</td>
				</tr>

			</table>
			<p class="text-danger">* 계좌 생성 시 필요한 최소 입금 금액은 1,000원 입니다.</p>
			
<!-- 			<p>* 계좌 생성 시 필요한 최소 입금 금액은 1,000원 입니다.</p> -->
			<br>
		<input class="btn btn-outline-primary" style="margin-left: 73%" type="submit" value="생성">
<!-- 			<input type="submit" value="생성"> -->
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




