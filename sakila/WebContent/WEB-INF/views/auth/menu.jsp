<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- 아이콘 -->
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<!-- menu -->
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3>Sakila Movie</h3>
		</div>
		<div style="margin: auto;">
			<table class="table table-borderless" style="margin: auto; text-align: center; width: 50%;">
				<tr>
					<td style="color:gray">	
						<i class="fas fa-user-circle fa-10x"></i>
						${staff.picture}
					</td>
				<tr>
				<tr>
					<td>
						<span>${loginStaff.storeId}</span> 지점
					</td>
				</tr>
				<tr>
					<td>
						<span>${loginStaff.username}</span> 관리자님
					</td>
				</tr>
			</table>
		</div>
	</div>
	<button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/auth/LogoutServlet'">로그아웃</button>