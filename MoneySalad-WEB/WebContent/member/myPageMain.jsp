<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/na/include/lib/topLibs.jsp"></jsp:include>
        <title>MoneySalad - 돈 관리가 쉬워지는</title>
        <style type="text/css">
        
        th {
        	text-align: center;
        }
        
        td {
        	padding-left: 1%;
        }
        
        </style>
        <script>
        	new WOW().init();
        	
        	function toList() {
        		location.href = "/Mission-WEB/jsp/member/memberList.jsp"
        	}
        	
        	function modifyInfo() {
        		location.href= "<%=request.getContextPath()%>/modifyMemberForm.do"
				
			}
        	
        	function resign() {
        		
        		if(confirm("정말로 탈퇴하시겠습니까?")){
        		location.href = "<%=request.getContextPath()%>/resignProcess.do"
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
                        <h1 class="mt-4">MyPage</h1>
                        <ol class="breadcrumb mb-4">
<%--                             <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/depoWithdrawMenu.do">MyPage</a></li> --%>
                            <li class="breadcrumb-item active">MyPage</li>
                        </ol>
                        
                        
                        		<div>
<!-- 			<hr width=80%> -->
			<h1>상세 회원정보</h1>
			<hr width=100%>
			
			<table  id="table1" border="1" style="width: 80%">
				<tr>
					<th class="table-dark" width="10%">아이디</th>
					<td class="table-light">${ member.id}</td>
				</tr>
				<tr>
					<th class="table-dark" width="25%">이름</th>
					<td class="table-light"><c:out value="${member.name}" /></td>
				</tr>
				<tr>
					<th class="table-dark" width="25%">이메일</th>
					<td class="table-light">${member.emailId }@${member.emailDomain}</td>
				</tr>
				<tr>
					<th class="table-dark" width="25%">전화번호</th>
					<td class="table-light">${member.tel1}-${member.tel2}-${member.tel3}</td>
				</tr>
				<tr>
					<th class="table-dark" width="25%">우편번호</th>
					<td class="table-light">${member.post}</td>
				</tr>
				<tr>
					<th class="table-dark" width="25%">상위주소</th>
					<td class="table-light">${member.basicAddr}</td>
				</tr>
				<tr>
					<th class="table-dark" width="25%">상세주소</th>
					<td class="table-light">${member.detailAddr}</td>
				</tr>
				</table>
				
				

<!-- 			<table id="table1" border=1> -->
<!-- 				<tr> -->
<!-- 					<td>아이디</td> -->
<%-- 					<td>${ member.id}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>이름</td> -->
<%-- 					<td>${member.name}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>이메일</td> -->
<%-- 					<td>${member.emailId }@${member.emailDomain}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>전화번호</td> -->
<%-- 					<td>${member.tel1}-${member.tel2}-${member.tel3}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>우편번호</td> -->
<%-- 					<td>${member.post}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>상위주소</td> -->
<%-- 					<td>${member.basicAddr}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>상세주소</td> -->
<%-- 					<td>${member.detailAddr}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>회원유형</td> -->
<%-- 					<td>${member.type}</td> --%>
<!-- 				</tr> -->

<!-- 			</table> -->

			<br>
			<div align="center">
			<c:choose>
				<c:when test="${ member.type eq 'S' }">
					<button class="btn btn-secondary disabled" onclick="toList()">회원 목록으로</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-secondary" onclick="modifyInfo()">회원정보 수정</button>
					<button class="btn btn-secondary" onclick="resign()">회원탈퇴</button>
				</c:otherwise>
			</c:choose>
			
			</div>
			

		</div>
                        
                        
                    </div>
                </main>
                	<jsp:include page="/na/include/layout/footer.jsp"></jsp:include>
                
            </div>
        </div>
	<jsp:include page="/na/include/lib/bottomLibs.jsp"></jsp:include>
	<script>
        
        	<%-- var userVO = '<c:out value="${userVO}"/>';
     
        	if(userVO == "") {
        	Swal.fire({
        		  icon: 'error',
        		  title: 'Oops...',
        		  text: '로그인이 필요한 서비스입니다.'
        		 
        		}).then((result) => {
        			location.href="<%=request.getContextPath()%>/login.do"
        				})
        } --%>
        
        </script>

</body>
</html>
