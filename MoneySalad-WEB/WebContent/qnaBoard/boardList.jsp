<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/na/include/lib/topLibs.jsp"></jsp:include>
        <title>MoneySalad - 돈 관리가 쉬워지는</title>
        <script>
        	new WOW().init();
        	
        	function goWriteForm() {
        		/* 		location.href = "writeForm.jsp";
        		 */location.href = "<%=request.getContextPath()%>/writeForm.do";
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
                        <h1 class="mt-4">QnA</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">QnA</li>
                        </ol>
                        <h2>게시판 목록</h2><br>
                        
                        			<table border="1" style="width: 80%">
				<tr>

					<th style="width: 7%">번호</th>
					<th>제목</th>
					<th style="width: 16%">글쓴이</th>
					<th style="width: 20%">등록일</th>
					<th style="width: 7%">조회수</th>
				</tr>
				<c:forEach items="${ boardList }" var="board" varStatus="loop">
					<tr <c:if test="${loop.count % 2 == 0 }"> class="even"</c:if>>
						<td>${ board.boardNo }</td>
						
						<c:choose>
						<c:when test="${board.boardNo == board.originalNo }">
						<td><a href="<%=request.getContextPath() %>/board.do?no=${board.boardNo }&type=list"> <c:out
									value="${board.title }" />
						</a></td>
						</c:when>
						<c:otherwise>
						<td>
						<c:forEach  begin="1" end="${board.boardDepth }">
						RE:
						</c:forEach>
						
						<a href="<%=request.getContextPath() %>/board.do?no=${board.boardNo }&type=list"> <c:out
									value="${board.title }" />
						</a></td>
						</c:otherwise>
						</c:choose>
						<td>${ board.id }</td>
							
						<c:set var="dbSimpleDate" value="${fn:substring(board.regDate,0,10) }"/>						
						<c:set var="dbTime" value="${fn:substring(board.regDate,11,16) }"/>						
							
									
						
					 	 <c:choose>
							<c:when test="${javaSimpleDate != dbSimpleDate  }">
								<td>${dbSimpleDate }</td>
							</c:when>
							<c:otherwise>
								<td>${dbTime }</td>
							</c:otherwise>
						</c:choose>   
						<td>${board.viewCnt}</td>
					</tr>
								
					
				</c:forEach>
				
			</table>
			
<%-- 			<c:forEach var="i" begin="1" end="${curLastPage }"> --%>
			<c:if test="${block -1 != 0 }">
			
			<a href="<%=request.getContextPath()%>/qnaBoardList.do?block=${block -1 }&page=${groupStartPage-1 }" >이전</a> &nbsp;
			</c:if>
			<c:forEach var="i" begin="${groupStartPage }" end="${groupEndPage }">
			<c:choose>
			<c:when test="${page == i }">
				${i }&nbsp;|&nbsp;
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath()%>/qnaBoardList.do?block=${block }&page=${i }" >${i }&nbsp;|</a>&nbsp;
			
			</c:otherwise>
			</c:choose>
			</c:forEach>
			<c:if test="${block != blockCnt}">
			<a href="<%=request.getContextPath()%>/qnaBoardList.do?block=${block+1 }&page=${groupEndPage+1 }" >다음</a> &nbsp;
			</c:if>
			
			<button onclick="goWriteForm()">새글 작성</button>
			
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




