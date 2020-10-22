<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>index.jsp</h1>
	<div>
		<span>${loginStaff.username}</span> 관리자님
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/LogoutServlet">로그아웃</a>
	</div>
</body>
</html>