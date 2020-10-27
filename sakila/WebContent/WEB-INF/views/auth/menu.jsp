<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- menu -->
	<div>
		<h3>Sakila Movie</h3>
	</div>
	
	<div>
		<table>
			<tr>
				<td>
					${staff.picture}
				</td>
			<tr>
			<tr>
				<td>
					<span>${loginStaff.storeId}</span> 지점
				</td>
				<td>
					<span>${loginStaff.username}</span> 관리자님
				</td>
			</tr>
		</table>
	</div>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/auth/LogoutServlet'">로그아웃</button>