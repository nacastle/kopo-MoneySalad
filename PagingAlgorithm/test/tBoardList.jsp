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
        	
        	function goWriteForm() {
        		 location.href = "<%=request.getContextPath()%>/writeForm.do";
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
                        <br>
                        <h2>게시판 목록</h2>


<!--==== 게시글 테이블 시작! (여기서부터 주목하시면 됩니다.) ======================================================================================= -->
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col" style="width: 7%">번호</th>
								<th scope="col">제목</th>
								<th scope="col" style="width: 16%">글쓴이</th>
								<th scope="col" style="width: 20%">등록일자</th>
								<th scope="col" style="width: 7%">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ boardList }" var="board" varStatus="loop">
								<tr class="table-success">
									<td>${ board.boardNo }</td>

									<td><a
										href="<%=request.getContextPath() %>/tBoard.do?blockNo=${blockNo }&pageNo=${pageNo }&no=${board.boardNo }&type=list">
											${board.title }
										</a>
									</td>
									
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
						</tbody>
					</table>
<!-- ====== 게시글 테이블 끝! ============================================================================== -->					

<!-- ====페이징======================================================================================= -->
	<div style="margin-left: 40%">
<!-- ---------이전 구현 --------------------------- -->
			<c:if test="${blockNo != 1 }"> 
				<a href="<%=request.getContextPath()%>/tBoardList.do?blockNo=${blockNo -1 }&pageNo=${blockStartPageNo-1 }" >이전</a> &nbsp;
			</c:if>
			
<!-- ---------페이지 구현 --------------------------- -->			
			<c:forEach var="i" begin="${blockStartPageNo }" end="${blockEndPageNo }">
				<c:choose>
				
					<c:when test="${pageNo == i }">
						${i }&nbsp;|&nbsp;
					</c:when>
					
					<c:otherwise>
						<a href="<%=request.getContextPath()%>/tBoardList.do?blockNo=${blockNo }&pageNo=${i }" >${i }&nbsp;</a>|&nbsp;
					</c:otherwise>
					
				</c:choose>
			</c:forEach>
			
<!-- ---------다음 구현 --------------------------- -->	
			<c:if test="${blockNo != totalBlockCnt}">&nbsp;
				<a href="<%=request.getContextPath()%>/tBoardList.do?blockNo=${blockNo+1 }&pageNo=${blockEndPageNo+1 }" >다음</a> &nbsp;
			</c:if>
	</div>	
	
<!-- ==== 페이징 끝! (여기까지만 보셔도 됩니다.)================================================================== -->	
	
			<div align="right" style="margin-right: 2%; margin-bottom: 2%;">
			
				<button class="btn btn-outline-primary" onclick="goWriteForm()">새글 작성</button>
			</div>
		</div>		
     			</main>
                
            </div>
        </div>
	<jsp:include page="/na/include/lib/bottomLibs.jsp"></jsp:include>
</body>
</html>




