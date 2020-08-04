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
        	
        	function confirmDelete() {
        		
        		if(confirm("정말로 삭제하시겠습니까?")){
        			location.href="<%=request.getContextPath()%>/deleteAccountProcess.do"
        		}
        		
				
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
                            <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/manageAccount.do">계좌관리</a></li>
                            <li class="breadcrumb-item active">계좌삭제</li>
                        </ol>
                        <div class="row">
                        <c:forEach items="${accountList }" var="account"> 
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
<%--                                     <span class="card-title">${account.bank }</span> <span class="card-title text-right">${account.nickname}</span><br> --%>
                                    <div class="card-body font-weight-bold">${account.bank } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${account.nickname}</div>
                                    <div class="card-title">&nbsp;&nbsp;${account.accountNumber }</div>
                                    <div class="card-body text-right">${account.balance } 원</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                    <form action="<%=request.getContextPath()%>/deleteAccountProcess.do" method="post">
                                    	<input type="hidden" name="accountNumber" value="${account.accountNumber}">
                                    	<button class="btn btn-info" type="submit" name="accountNumber" onclick="confirmDelete()" >계좌삭제</button> <!-- onclick="confirmDelete()" -->
                                    </form>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                        
                    </div>
                </main>
                	<jsp:include page="/na/include/layout/footer.jsp"></jsp:include>
                
            </div>
        </div>
	<jsp:include page="/na/include/lib/bottomLibs.jsp"></jsp:include>
	<script>
        
        	var userVO = '<c:out value="${userVO}"/>';
     
        	if(userVO == "") {
        	Swal.fire({
        		  icon: 'error',
        		  title: 'Oops...',
        		  text: '로그인이 필요한 서비스입니다.'
        		 
        		}).then((result) => {
        			location.href="<%=request.getContextPath()%>/login.do"
        				})
        }
        
        </script>

</body>
</html>
