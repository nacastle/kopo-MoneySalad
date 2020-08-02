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

id: ${account.id }
nick: ${account.nickname }
계좌번호: ${account.accountNumber }
은행: ${account.bank }
계좌주: ${account.accountOwner }
잔액: ${account.balance }

<hr>


</body>
</html>