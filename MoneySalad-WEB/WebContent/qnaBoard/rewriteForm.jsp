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
        	
        	function doWrite() {

        		let f = document.wForm;

        		if (f.title.value == "") {
        			alert("제목을 입력하세요")
        			f.title.focus()
        			return false
        		}

        		/* if(f.writer.value == "") {
        			alert("글쓴이를 입력하세요")
        			f.writer.focus()
        			return false
        		} */

        		if (f.content.value == "") {
        			alert("내용을 입력하세요")
        			f.content.focus()
        			return false
        		}

        		// 파일 확장자 체크
        		if (checkExt(f.attachfile1)) {
        			return false
        		}

        		if (checkExt(f.attachfile2)) {
        			return false
        		}
        		
        		if(confirm("등록하시겠습니까?")){
        			return true;
        		}

        		return true;

        	}

        	function checkExt(obj) {
        		let forbidName = [ 'exe', 'bat', 'java', 'js', 'class', 'jsp' ];
        		let fileName = obj.value;

        		let searchIdx = fileName.lastIndexOf('.');
        		let ext = fileName.substring(searchIdx + 1);

        		for (let i = 0; i < forbidName.length; i++) {

        			if (forbidName[i] == ext) {
        				alert('[' + ext + '] 확장자는 파일 업로드 정책에 위배됩니다.');
        				return true
        			}

        		}

        		return false

        	}

        	function doList() {
        		location.href = "<%=request.getContextPath()%>/qnaBoardList.do?block=1&page=1"

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
                        <h1 class="mt-4">답글 작성</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/qnaBoardList.do">QnA</a></li>
                            <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/board.do?no=${boardNo}">게시글</a></li>
                            <li class="breadcrumb-item active">답글 작성</li>
                        </ol>
                        
            <hr width="80%">
		<h2>답글 작성폼${boardNo }</h2>
		<hr width="80%">
		<br>
		<form action="<%=request.getContextPath()%>/rewriteProcess.do" name="wForm" method="post"
			autocomplete="off" onsubmit="return doWrite()"
			enctype="multipart/form-data">

			<input type="hidden" name="writer" value="${userVO.id }">
			<input type="hidden" name="parentNo" value="${boardNo }">
			
			<table border="1" style="width: 80%">
				<tr>
					<th width="23%">제목</th>
					<td><input type="text" name="title" size="100%"<%-- required="required" --%>></td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td>${userVO.id }</td>
					<%-- 					<td><input type="text" name="writer" size="100%"
						value="${userVO.id }" readonly="readonly"></td> --%>
					<!--  					<td><input type="text" name="writer" size="100%"required="required"></td> -->
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="7" cols="60" name="content"<%-- required="required" --%>></textarea></td>
				</tr>

				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="attachfile1"><br> <input
						type="file" name="attachfile2"><br></td>
				<tr>
			</table>
			<br>

			<%-- 			<button type="submit"></button> button 쓰든가 input 쓰든가 2가지 방식
 --%>
			<input type="submit" value="등록">
			<%-- <input type="button" value="목록" id="btnList"> --%>
			<input type="button" value="목록" onclick="doList()" />
		</form>
		

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




