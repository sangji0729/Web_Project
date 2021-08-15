<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
<style type="text/css">
#joinbox{
	margin: 0 auto;
	padding: 0;
	text-align: center;
}
</style>
</head>
<body>
<h1 style="text-align: center;">회원가입</h1>
<div id="joinbox">
	<form action="./join" method="post">
		ID  <input type="text" id="id" name="id"><br>
		비밀번호 <input type="password" id="pw" name="pw"><br>
		이름 <input type="text" id="name" name="name"><br>
		E-mail <input type="email" id="email" name="email">
		<button>메일 인증하기</button>
		<br>
		E-mail 인증 <input type="email" id="emailAuthor" name="emailAuthor">
		<button type="submit">회원가입</button>	
	</form>
</div>
</body>
</html>