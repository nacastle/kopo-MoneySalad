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

        		if (f.withdrawAmount.value == "") {
        			alert("출금할 금액을 입력해주세요.")
        			f.withdrawAmount.focus()
        			return false
        		}


        		return confirm("출금하시겠습니까?");

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
                        <h1 class="mt-4">출금금액</h1>
                        <ol class="breadcrumb mb-4">
                        
							<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/depoWithdrawMenu.do">입출금거래</a></li>
							<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/depositForm.do">출금</a></li>
                            <li class="breadcrumb-item active">출금금액</li>
                        </ol>
                        
<!--          <hr width="80%"> -->
		<h2>입금할 금액</h2>
		<hr width="100%">
		<br>
		<br>
		<form action="<%=request.getContextPath()%>/withdrawProcess.do" name="wForm" method="post"
			autocomplete="off" onsubmit="return doRegister()">

			<input type="hidden" name="accountNumber" value="${accountNumber }">
			
						<div class="form-group">
    		  <label for="exampleInputEmail1">출금할 금액</label>
     		 <input type="number" name="withdrawAmount" style="width: 20%" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">
     		 <small id="emailHelp" class="form-text text-muted">출금하실 금액을 입력해주세요. 잔액을 초과하지 않아야 합니다.</small>	<p class="text-info"><i>현재 잔액 : ${balance } 원</i></p>
  		  </div>
    
    
<!-- 			<table border="1" style="width: 80%"> -->
<!-- 				<tr> -->
<!-- 					<th width="23%">입금할 금액</th> -->
<!-- 					<td><input type="number" name="depositAmount" size="20%">&nbsp;원</td> -->
<!-- 				</tr> -->

<!-- 			</table> -->
			<br>
<!-- 			<button type="button" class="btn btn-outline-primary">Primary</button> -->
			
			<input class="btn btn-outline-warning" style="margin-left: 2%" type="submit" value="출금">
		</form>
		
		
<%-- 			현재 잔액 : ${balance } 원 --%>
<!-- 			<table border="1" style="width: 80%"> -->
<!-- 				<tr> -->
<!-- 					<th width="23%">출금할 금액</th> -->
<!-- 					<td><input type="number" name="withdrawAmount" size="20%">&nbsp;원</td> -->
<!-- 				</tr> -->

<!-- 			</table> -->
<!-- 			<br> -->

<!-- 			<input type="submit" value="출금"> -->
<!-- 		</form> -->
		

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




