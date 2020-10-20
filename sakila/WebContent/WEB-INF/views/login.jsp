<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div>
		오늘 접속자 수 : ${map["stats"].count} / 전체 접속자 수 : ${map["totalCount"]}
	</div>
	<form>
		<div>
			<input type="text" placeholder="ID">
		</div>
		<div>
			<input type="password" placeholder="PW">
		</div>
		<div>
			<button type="button">Log-in</button>
		</div>
	</form>
</body>
</html>