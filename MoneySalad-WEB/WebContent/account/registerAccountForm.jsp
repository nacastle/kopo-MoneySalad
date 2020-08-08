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

        		if (f.selectBank.value == "") {
        			alert("은행을 선택해주세요")
//         			f.depositAmount.focus()
        			return false
        		}
        		if (f.accountNumber.value == "") {
        			alert("계좌번호를 입력해주세요.")
        			f.accountNumber.focus()
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
                        <h1 class="mt-4">새 계좌 등록</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">새 계좌 등록</li>
                        </ol>
                        
<!--          <hr width="80%"> -->
		<h3>계좌등록양식</h3>
		<hr width="100%">
		<br>
		<form action="<%=request.getContextPath()%>/registerAccountProcess.do" name="wForm" method="post"
			autocomplete="off" onsubmit="return doRegister()">

			<input type="hidden" name="balance" value="${balance }"> 
			<table border="1" style="width: 80%">
				<tr>
					<th width="23%">은행 선택</th>
					<td>&nbsp;
						<input type="radio" name="selectBank" value="캐슬은행"> 캐슬은행 
						<input type="radio" name="selectBank" value="하나은행"> 하나은행 
						<input type="radio" name="selectBank" value="우리은행"> 우리은행 
						<input type="radio" name="selectBank" value="기업은행"> 기업은행 
						<input type="radio" name="selectBank" value="국민은행"> 국민은행 
						<input type="radio" name="selectBank" value="신한은행"> 신한은행 
						<input type="radio" name="selectBank" value="농협은행"> 농협은행 
					
					</td>
				</tr>
				<tr>
					<th>계좌번호 입력</th>
					<td><input type="text" name="accountNumber" size="15%"></td>
				</tr>
				<tr>
					<th>별칭 입력</th>
					<td><input type="text" name="nickname" size="15%"></td>
				</tr>

			</table>
			<br>
		<input class="btn btn-outline-primary" style="margin-left: 73%" type="submit" value="등록">

<!-- 			<input type="submit" value="등록"> -->
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




