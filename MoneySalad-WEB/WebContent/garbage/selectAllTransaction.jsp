<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    
            <jsp:include page="/na/include/lib/topLibs.jsp"></jsp:include>
    
        
        <title>Static Navigation - SB Admin</title>
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
							<c:forEach items="${transactionList }" var="transaction">
								거래일자: ${transaction.transactionDate }<br>
								본인계좌: ${transaction.accountNumber }<br>
								상대계좌: ${transaction.counterAccountNumber }<br>
								거래유형: ${transaction.transactionType }<br>
								거래금액: ${transaction.transactionAmount }<br>
								<hr>
							</c:forEach>
                </main>

			<jsp:include page="/na/include/layout/footer.jsp"></jsp:include>

            </div>
        </div>
        	<jsp:include page="/na/include/lib/bottomLibs.jsp"></jsp:include>
        
    </body>
</html>
    


<!-- <h2>입출금내역</h2> -->
<%-- <c:forEach items="${transactionList }" var="transaction"> --%>
<%-- 	거래일자: ${transaction.transactionDate }<br> --%>
<%-- 	본인계좌: ${transaction.accountNumber }<br> --%>
<%-- 	상대계좌: ${transaction.counterAccountNumber }<br> --%>
<%-- 	거래유형: ${transaction.transactionType }<br> --%>
<%-- 	거래금액: ${transaction.transactionAmount }<br> --%>
<!-- 	<hr> -->
<%-- </c:forEach> --%>


