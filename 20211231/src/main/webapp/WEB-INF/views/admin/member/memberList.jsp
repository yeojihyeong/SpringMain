<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Member</h1>
		<p class="mb-4"></p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">회원목록</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>id</th>
								<th>name</th>
								<th>tel</th>
								<th>address</th>
								<th>author</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${members }" var="member">
								<tr>
									<th>${member.id }</th>
									<th>${member.name }</th>
									<th>${member.tel }</th>
									<th>${member.address }</th>
									<th>${member.author }</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>