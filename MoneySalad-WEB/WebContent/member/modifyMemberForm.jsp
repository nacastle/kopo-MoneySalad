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
        	width: 15%;
        	text-align: center;
        }
        
        td {
        	padding-left: 1%;
        
        }
        
        </style>
        <script>
        	new WOW().init();
        	
        	function selectEmail() {

        		var f2 = document.sForm;

        		if (f2.email_domain2.selectedIndex == '0') {
        			f2.email_domain1.readOnly = false;
        			f2.email_domain1.value = "";
        			f2.email_domain1.focus();

        		} else {

        			f2.email_domain1.value = f2.email_domain2.value
        			f2.email_domain1.readOnly = true;

        		}
        	}
        	
        	function doSignUp() {

        		var f = document.sForm;

        		

        		if (f.email_domain1.value == "") {
        			alert("이메일을 입력하세요")
        			f.email_domain1.focus()
        			return false
        		}

        		if (f.tel1.value == "") {
        			alert("전화번호 앞 자리를 입력하세요")
        			f.tel1.focus()
        			return false
        		}

        		if (f.tel2.value == "") {
        			alert("전화번호 중간 자리를  입력하세요")
        			f.tel2.focus()
        			return false
        		}

        		if (f.tel3.value == "") {
        			alert("전화번호 마지막 자리를 입력하세요")
        			f.tel3.focus()
        			return false
        		}

        		if (f.post.value == "") {
        			alert("우편번호를 입력하세요")
        			f.post.focus()
        			return false
        		}

        		if (f.basic_addr.value == "") {
        			alert("상위주소를 입력하세요")
        			f.basic_addr.focus()
        			return false
        		}

        		if (f.detail_addr.value == "") {
        			alert("상세주소를 입력하세요")
        			f.detail_addr.focus()
        			return false
        		}
        		
        		

        		

        		return confirm("수정하시겠습니까?");

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
                        <h1 class="mt-4">회원정보수정</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/myPageMain.do">MyPage</a></li>
                            <li class="breadcrumb-item active">회원정보수정</li>
                        </ol>
                        
                        
                        		<div>
<!-- 			<hr width=80%> -->
			<h1>회원정보 수정양식</h1>
			<hr width=100%>
			
			<form action="<%=request.getContextPath() %>/modifyMemberProcess.do" name="sForm" autocomplete="off"
			method="post" onsubmit="return doSignUp()">

			<table style="width: 70%" id="table1" border=1>
				<tr>
					<th>아이디</th>
					<td>${ member.id}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${member.name}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
					<input type="text" name="email_id" value="${member.emailId }">@
					<input type="text" name="email_domain1" value="${member.emailDomain}">
			<select name="email_domain2" id="email_domain2" onchange="selectEmail();">
				<option value="type">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="kopo.ac.kr">kopo.ac.kr</option>
			</select>
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" style="width: 10%" name="tel1" size="10%" value="${member.tel1 }"> ㅡ
					<input type="text" style="width: 10%" name="tel2" size="10%" value="${member.tel2}"> ㅡ
					<input type="text" style="width: 10%" name="tel3" size="10%" value="${member.tel3}"></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="text" name="post" maxlength="5" value="${member.post}"></td>
				</tr>
				<tr>
					<th>상위주소</th>
					<td><input type="text" style="width: 35%" name="basic_addr" value="${member.basicAddr}"></td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td><input type="text" style="width: 35%" name="detail_addr"value="${member.detailAddr}"></td>
				</tr>
				

			</table>
			<div align="left">
			<button class="btn btn-secondary" style="margin: 2%" type="submit">수정완료</button>
			</div>
			</form>

			<br>
			

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
