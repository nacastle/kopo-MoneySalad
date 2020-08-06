<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/na/include/lib/topLibs.jsp"></jsp:include>
        <title>MoneySalad - 돈 관리가 쉬워지는</title>
        <script>
        	new WOW().init();
        </script>
    </head>
    <body class="sb-nav-fixed">
    	<jsp:include page="/na/include/layout/topnav.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="/na/include/layout/sidenav.jsp"></jsp:include>
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">특정계좌조회</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>">전계좌조회</a></li>
                            <li class="breadcrumb-item active">특정계좌조회</li>
                        </ol>
                        <h2>입출금내역</h2>

					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">거래유형</th>
								<th scope="col">거래일자</th>
								<th scope="col">거래대상</th>
								<th scope="col">My계좌</th>
								<th scope="col">거래금액</th>
								<th scope="col">잔액</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${transactionList }" var="transaction">
								<c:choose>
								<c:when test="${transaction.transactionType == 'D' }">
							<tr class="table-success">
								<th scope="row">
								입금
								</th>
								
								<td>${transaction.transactionDate }</td>
								<td>${transaction.counterAccountNumber }</td>
								<td>${transaction.accountNumber }</td>
								<td>${transaction.transactionAmount } 원</td>
								<td>${transaction.balance } 원</td>
							</tr>
							</c:when>
								<c:otherwise>
								<tr class="table-warning">
								<th scope="row">
								출금
								</th>
								
								<td>${transaction.transactionDate }</td>
								<td>${transaction.counterAccountNumber }</td>
								<td>${transaction.accountNumber }</td>
								<td>${transaction.transactionAmount } 원</td>
								<td>${transaction.balance } 원</td>
							</tr>
								</c:otherwise>
								</c:choose>
							</c:forEach>
							
<%-- 							</c:when> --%>
<%-- 								<c:otherwise> --%>
<!-- 								출금 -->
<%-- 								</c:otherwise> --%>
<%-- 								</c:choose> --%>
<!-- 								</th> -->

						</tbody>
					</table>

<%-- 					<c:forEach items="${transactionList }" var="transaction"> --%>
<%-- 								거래일자: ${transaction.transactionDate }<br> --%>
<%-- 								본인계좌: ${transaction.accountNumber }<br> --%>
<%-- 								상대계좌: ${transaction.counterAccountNumber }<br> --%>
<%-- 								거래유형: ${transaction.transactionType }<br> --%>
<%-- 								거래금액: ${transaction.transactionAmount } 원<br> --%>
<%-- 								잔액: ${transaction.balance } 원 --%>
<!-- 								<hr> -->
<%-- 							</c:forEach> --%>
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
