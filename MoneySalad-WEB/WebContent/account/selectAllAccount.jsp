<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>


var userVO = '<c:out value="${userVO}"/>';

if(userVO == "") {
	alert("로그인이 필요한 서비스입니다.")
	location.href="/MoneySalad/login/login.jsp"
}

</script>
</head>
<body>


<h2>계좌 조회</h2>
<hr>


<c:forEach items="${accountList }" var="account">
아이디: ${account.id }<br>
별칭: ${account.nickname }<br>
계좌번호: ${account.accountNumber }<br>
계좌은행: ${account.bank }<br>
계좌주: ${account.accountOwner }<br>
잔액: ${account.balance }원<br>
<form action="<%=request.getContextPath() %>/selectAccount.do" method="post">
<input type="hidden" name="accountNumber" value="${account.accountNumber }">
<button type="submit">상세보기(입출금내역)</button>
</form>
<hr>
</c:forEach>


</body>
</html>