<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Page Title - SB Admin</title>
        <link href="/MoneySalad-WEB/dist/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
        <script src="/Mission-WEB/js/sendProcess.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        
<style>
	.red {
		color: red;
	}
	
	.green {
		color: green;
	}
</style>
        
<script>
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

		if (f.id.value == "") {
			alert("아이디를 입력하세요")
			f.id.focus()
			return false
		}
		
		if (click == false) {
			alert("아이디 중복체크를 해주세요.")
			f.idCheck.focus();
			return false;
		}

		if (tMsg == "unavailable") {
			alert("아이디가 중복됩니다. 아이디를 확인해주세요.")
			f.id.focus()
			return false
		}
		
		

		if (f.name.value == "") {
			alert("이름을 입력하세요")
			f.name.focus()
			return false
		}

		if (f.password.value == "") {
			alert("패스워드를 입력하세요")
			f.password.focus()
			return false
		}

		if (f.password.value != f.passwordConfirm.value) {
			alert("입력한 패스워드가 다릅니다.")
			f.passwordConfirm.focus()
			return false
		}

		if (f.email_id.value == "") {
			alert("이메일을 입력하세요")
			f.email_id.focus()
			return false
		}

		if (f.email_domain1.value == "") {
			alert("이메일을 입력하세요")
			f.email_domain1.focus()
			return false
		}

		if (f.tel1.value == "") {
			alert("전화번호 앞 3자리를 입력하세요")
			f.tel1.focus()
			return false
		}

		if (f.tel2.value == "") {
			alert("전화번호 중간 4자리를  입력하세요")
			f.tel2.focus()
			return false
		}

		if (f.tel3.value == "") {
			alert("전화번호 마지막 4자리를 입력하세요")
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

		if (f.type.value == "") {
			alert("회원유형을 입력하세요")
			f.type.focus()
			return false
		}

		return true;

	}
	
	
	

	
	$(document).ready(function() {
		$("#validateId").click(function() {
			let checkId = $("#userId").val();
			
			$.ajax({
				url : '<%=request.getContextPath()%>/idValidation.do',
				type : 'post',
				data : {
					'checkId' : checkId
				},
				success : isAvailable,
				error : function() {
					alert("error!")
					
				}
			
			})
			
		});
		
		$("#userId").keypress(function() {
// 			alert("키 감지")
			click = false;
			$("#validateMsg").html("")
// 			console.log(click)
			
		})
		
	})
	
	

	

	let tMsg = null;
	function isAvailable(msg) {
		

// 		let checkId = document.getElementById('userId').value;
// 		let responseLoc = document.getElementById("validateMsg");
		let checkId = $("#userId").val();
		let responseLoc = $("#validateMsg");
		tMsg = msg.trim()

		if (tMsg == "available" && checkId != "") {
			responseLoc.html("사용 가능한 아이디입니다.");
			$('#validateMsg').removeClass("red");
			$('#validateMsg').addClass("green");

		} else if (tMsg == "unavailable") {

			responseLoc.html("중복된 아이디입니다. 다시 설정해주세요.");
			$('#validateMsg').removeClass("green");
			$('#validateMsg').addClass("red");
		} else {
			responseLoc.html("아이디를 입력해주세요.");
			$('#validateMsg').removeClass("red");
			$('#validateMsg').removeClass("green");

		}

	}
	
	let click = false;
	function isClick() {
		click = true;
		console.log(click)
		
	}
// 	function isChange() {
// 		click = false;
// // 		$("#userId").html()
		
// 		console.log(click)
// 	}
	
	
</script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        		<form action="<%=request.getContextPath() %>/signUpProcess.do" name="sForm" autocomplete="off"
			method="post" onsubmit="return doSignUp()">
			
			<hr>
			<h1>회원가입 양식</h1>
			<hr>
			
			아이디 <br>
			<input type="text" name="id" id="userId">
			<input type="button" value="중복검사" name="idCheck" id="validateId" onclick="isClick()"  > &nbsp; <!-- onkeyup="isChange()" --> <!--  onclick="idValidation('POST',document.getElementById('userId').value); isClick()" -->   
										<span id="validateMsg"></span><br><br> 
			이름 <br>
			<input type="text" name="name"><br><br>
			
			비밀번호<br>
			<input type="password" name="password"><br><br>
			
			비밀번호 확인<br>
			<input type="password" name="passwordConfirm"><br><br>
			
			이메일 <br>
			<input type="text" name="email_id">@<input type="text" name="email_domain1">
			<select name="email_domain2" id="email_domain2" onchange="selectEmail();">
				<option value="type">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="kopo.ac.kr">kopo.ac.kr</option>
			</select><br><br>
			
			Tel<br>
			<input type="text" name="tel1" maxlength="3" style="width: 5%">
			-<input type="text" style="width: 8%" name="tel2" maxlength="4">
			-<input type="text" style="width: 8%" name="tel3" maxlength="4"><br><br>
			
			우편번호<br>
			<input type="text" name="post" maxlength="5"><br><br>
			
			상위주소
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상세주소<br>
			<input type="text" name="basic_addr">
			<input type="text" name="detail_addr"><br><br>
			
			회원유형<br>
			S<input type="radio" name="type" value="S">
			U<input type="radio" name="type" value="U" checked="checked"><br><br>
			
			<input type="submit" value="가입하기">
		</form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="<%=request.getContextPath()%>/login.do">Have an account? Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/MoneySalad-WEB/dist/js/scripts.js"></script>
    </body>
</html>
