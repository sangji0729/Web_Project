<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
#id{
	margin: 0 auto;
	padding: 0;
	height: 30px;
	width: 250px;
	margin-bottom: 5px;
	margin-left: 580px;
	vertical-align: middle;
	border-radius: 5px;
}
#pw{
	margin: 0 auto;
	padding: 0;
	height: 30px;
	width: 250px;
	margin-bottom: 5px;
	margin-left: 580px;
	vertical-align: middle;
	border-radius: 5px;
}
#loginbtn{
	height: 30px;
	width: 100px;
	margin-left: 660px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">로그인</h1>
	<div id="loginbox">
		<form action="./login" method="post">
			<input type="text" id="id" name="id" required="required"
				placeholder="아이디를 입력하세요"><br> <input type="password"
				id="pw" name="pw" required="required" placeholder="비밀번호를 입력하세요">
			<button id="loginbtn">로그인</button>
		</form>
		<button onclick="location.href='./join.jsp'">회원가입</button>
	</div>
</body>
</html>