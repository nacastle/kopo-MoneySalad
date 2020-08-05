<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

// location.href = "${url}";

</script>
</head>
<body>

<form action="<%= request.getContextPath()%>/transfer.do" method="post" name="tForm">
	<input type="hidden" name="balance" value="${ balance}">
	<input type="hidden" name="accountNumber" value="${ accountNumber}">
</form>


<script>
/* location.href = "${url}"; */
alert("${msg}");
var form = document.tForm;
form.submit();




	

</script>





</body>
</html>