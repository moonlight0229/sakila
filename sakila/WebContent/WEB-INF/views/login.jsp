<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- 로그인 유효성 검사 -->
	<script>
		$(document).ready(function() {
			$("#btn").click(function() {
				if ($("#email").val() == "") {
					alert("이메일을 입력해주세요");
					return;
				} else if ($("#password").val() == "") {
					alert("비밀번호를 입력해주세요");
					return;
				}
				
				alert("E-Mail : " + $("#email").val() + "/ Password : " + $("#password").val())
				$("#loginForm").submit();
			});
		});
	</script>
</head>
<body>
	<div>
		오늘 방문자 수 : ${todayStats.cnt} / 총 방문자 수 : ${totalStats}
	</div>
	<form method="post" action="<%=request.getContextPath() %>/LoginServlet" id="loginForm">
		<div>
			<input type="text" name="staffEmail" placeholder="E-mail" id="email">
		</div>
		<div>
			<input type="password" name="staffPw" placeholder="Password" id="password">
		</div>
		<div>
			<button type="button" id="btn">Log-in</button>
		</div>
	</form>
</body>	
</html>