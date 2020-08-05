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

        		if (f.depositAmount.value == "") {
        			alert("입금할 금액을 입력해주세요.")
        			f.depositAmount.focus()
        			return false
        		}


        		return confirm("입금하시겠습니까?");

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
                        <h1 class="mt-4">입출금거래</h1>
                        <ol class="breadcrumb mb-4">
                        
							<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/depoWithdrawMenu.do">입출금거래</a></li>
							<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/depositForm.do">입금</a></li>
                            <li class="breadcrumb-item active">입금금액</li>
                        </ol>
                        
         <hr width="80%">
<!-- 		<h2>입금할 금액</h2> -->
		<hr width="80%">
		<br>
		<br>
		<form action="<%=request.getContextPath()%>/depositProcess.do" name="wForm" method="post"
			autocomplete="off" onsubmit="return doRegister()">
			
			<input type="hidden" name="accountNumber" value="${accountNumber }">
			현재 잔액 : ${balance } 원
			<table border="1" style="width: 80%">
				<tr>
					<th width="23%">입금할 금액</th>
					<td><input type="number" name="depositAmount" size="20%">&nbsp;원</td>
				</tr>

			</table>
			<br>

			<input type="submit" value="입금">
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




