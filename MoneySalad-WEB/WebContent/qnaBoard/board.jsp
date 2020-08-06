	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/na/include/lib/topLibs.jsp"></jsp:include>
        <title>MoneySalad - 돈 관리가 쉬워지는</title>
        <script type="text/javascript">
        	new WOW().init();
        	
        	
        	function doAction(type) {
        		switch (type) {
        		case 'U':
        			if (confirm('수정하시겠습니까?')) {
        				location.href = "/MoneySalad-WEB/editForm.do?no=${board.boardNo}";
        			}
        			break;
        		case 'D':
        			if (confirm('삭제하시겠습니까?')) {
        				location.href = "/MoneySalad-WEB/deleteBoard.do?no=${board.boardNo}";
        			}
        			break;
        		case 'R':
        			if (confirm('답글을 작성하시겠습니까?')) {
        				location.href = "/MoneySalad-WEB/rewriteForm.do?no=${board.boardNo}";
        			}
        			break;
        		case 'L':
        			location.href = "/MoneySalad-WEB/qnaBoardList.do?block=1&page=1";
        			break;
        		}
        	}
        	
        	function download(fileNo) {
        		location.href= "<%=request.getContextPath()%>/download.do?fileNo="+fileNo
        		
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
                        <h1 class="mt-4">게시글</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/qnaBoardList.do?block=1&page=1">QnA</a></li>
                            <li class="breadcrumb-item active">게시글</li>
                        </ol>
                        
            <h2>${board.title }</h2>
			<hr>
			<br>
			<table border="1">
				<tr>
					<th width="25%">번호</th>
					<td>${ board.boardNo }</td>
				</tr>
				<tr>
					<th width="25%">제목</th>
					<td><c:out value="${board.title }" /></td>
				</tr>
				<tr>
					<th width="25%">글쓴이</th>
					<td>${ board.id }</td>
				</tr>
				<tr>
					<th width="25%">조회수</th>
					<td>${ board.viewCnt }</td>
				</tr>
				<tr>
					<th width="25%">등록일</th>
					<td>${ board.regDate }</td>
				</tr>
				<tr>
					<th width="25%">내용</th>
					<td>${ board.content }</td>
				</tr>
				<tr>
					<th width="25%">첨부파일</th>
					 
					<td>
						<c:forEach items="${fileList }" var="file">
							<a href="<%=request.getContextPath() %>/upload/${file.fileSaveName }">
							${file.fileOriName }
							</a>
							 
							(${file.fileSize } bytes)
							<input type="button" value="다운로드" onclick="download(${file.no})"><br>
						</c:forEach>
					</td>
				</tr>
			</table>
			<br> 
			<c:if test="${userVO.id == board.id }">
				<input type="button" value="수정" onclick="doAction('U')">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="doAction('D')">&nbsp;&nbsp;
			</c:if>
				<input type="button" value="답글" onclick="doAction('R')">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="doAction('L')">&nbsp;&nbsp;

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



