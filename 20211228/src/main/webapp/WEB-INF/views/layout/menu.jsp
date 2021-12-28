<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="home.do">Home</a></li>
				<c:if test="${id eq null }">
					<li><a href="memberLoginForm.do">Login</a></li>
				</c:if>
				<c:if test="${id ne null }">
					<li><a href="memberLogout.do">LogOut</a></li>
				</c:if>
				<li><a href="#">Contact</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Product</a></li>
				
				<c:if test="${(author eq 'admin') or (author eq 'ADMIN')}">
				<li><a href="#">Service</a></li>
				<li><a href="memberSelectList.do">Members</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>