<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login.jsp</title>
	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<!-- 아이콘 -->
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<!-- 로그인 유효성 검사 -->
	<script>
		$(document).ready(function() { // 문서가 로드되면 이 스크립트를 제일 마지막에 실행
			$("#btn").click(function() { // 버튼 클릭 시 폼 내용의 유효성 검사 수행
				if ($("#email").val() == "") { // email이 공백인 경우
					alert("이메일을 입력해주세요"); // 알림 출력
					return;
				} else if ($("#password").val() == "") { // password가 공백인 경우
					alert("비밀번호를 입력해주세요"); // 알림 출력
					return;
				}
				
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
		<table class="table table-borderless" style="margin: auto; text-align: center; width: 50%;">
			<tr>
				<td style="color:gray">
					<i class="fas fa-user-circle fa-10x"></i>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" class="form-control" name="email" placeholder="E-mail" id="email">
				</td>
			</tr>		
			<tr>
				<td>
					<input type="password" class="form-control" name="password" placeholder="Password" id="password">
				</td>
			</tr>
			<tr>
				<td>
					<button type="button" class="btn btn-primary" id="btn">로그인</button>
				</td>
			</tr>
		</table>
	</form>
</body>	
</html>