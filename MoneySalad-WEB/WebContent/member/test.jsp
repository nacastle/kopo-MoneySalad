<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>

<script>

$(document).ready(function() {
	$("#test").keypress(function() {
		alert("키 변경 감지")
		
	})
	
})

</script>
</head>
<body>

<input type="text" id="test">





</body>
</html>