<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div align="center">
		<div>
			<h3>회원가입</h3>
		</div>
		<div>
			<form id="frm" action="memberInsert.do" onsubmit="return formCheck()" method="post"
				enctype="multipart/form-data">
				<table border="1">
					<tr>
						<th>아이디</th>
						<td><input type="email" id="id" name="id" required="required">
							&nbsp;&nbsp;
							<button type="button" id="idCheck" value="No"	onclick="ajaxIdCheck()">중복체크</button>
								</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="password" name="password"
							required="required"></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" id="password1" name="password1"
							required="required"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" name="name"
							required="required"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" id="tel" name="tel"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" id="address" name="address"></td>
					</tr>
					<tr>
						<th>사진</th>
						<td><input type="file" id="file" name="file"></td>
					</tr>
				</table><br>
				<input type="submit" value="회원가입">&nbsp;&nbsp; <input
					type="reset" value="취 소">
			</form>
		</div>
	</div>
	<script type="text/javascript">
		/* 함수 호출에 의해서 나오는 펑션은 보통 body 하단부분에 작성  */
		function ajaxIdCheck() {
			$.ajax({
				url : "ajaxIdCheck.do",
				type : "post",
				data : {
					id : $('#id').val()
				},
				dataType : "text",
				success : function(str) {
					var b = (str === 'true'); // boolean 으로 값을받음		
					if (b == false) {
						alert("이미 존재하는 아이디 입니다.");
						$("#id").val('');
						$("#id").focus();
					} else {
						alert("사용 가능한 아이디 입니다.");
						$("#idCheck").val('Yes');
						$("#idCheck").hide();
						$("#password").focus();
					}
				},
				error : function() {
					alert("아이디 중복체크 과정에서 오류발생");
				}
			});

		}

		function formCheck() {
			if ($("#idCheck").val() == 'No') { /* frm.idCheck.value == 'No' 도 가능 */
				alert("아이디 중복 체크를 해 주세요.");
				return false;
			}
			if ($("#password").val() != $("#password1").val()) {
				alert("패스워드가 일치하지 않습니다.")
				$("#password").val('');

				$("#password").focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>