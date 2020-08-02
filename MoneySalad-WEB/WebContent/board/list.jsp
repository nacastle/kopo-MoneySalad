<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글 등록</h2>
	<hr>
	<table>
		<tr>
			<th>제목</th>
			<th>글쓴이</th>
		</tr>

		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.title }</td>
				<td>${board.writer }</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>