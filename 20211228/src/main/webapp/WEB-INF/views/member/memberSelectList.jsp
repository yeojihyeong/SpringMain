<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	
	<div><h3>회원목록</h3></div>
	<div>
		<form id="frm" action="" method="post">
			<select	id="key" name="key">
				<option value="all" selected="selected">전체</option>
				<option value="name">이름</option>
				<option value="tel">전화번호</option>
				<option value="address">주소</option>
			</select>
			<input type="text" id="data" name="data" size="25" onkeypress="eventKey(this);">&nbsp;
			<button type="button" onclick="searchData()">검 색</button>
		</form>
	</div><br>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="150">아 이 디</th>
					<th width="150">이   름</th>
					<th width="150">전화번호</th>
					<th width="150">주   소</th>
					<th width="150">권   한</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members }" var="member">
					<tr>
						<td align="center">${member.id }</td>
						<td align="center">${member.name }</td>
						<td align="center">${member.tel }</td>
						<td>&nbsp;${member.address }</td>
						<td align="center">${member.author }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript">
	function eventKey(enterKey) {
		if(enterKey==13){
 		searchData();			
		}else{
			return false;
		}
	}
	function searchData() { 
		$.ajax({
			url : "ajaxSearchMember.do",
			type : "post", 
			data : {"key" : $("#key option:selected").val(), "data" : $("#data").val()},
			dataType: "json",
			success : function(result) {
				console.log(result); //수정필요
				alert(result);
			}
		});
	}
</script>
</body>
</html>