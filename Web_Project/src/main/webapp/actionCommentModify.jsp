<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글수정</title>
<style type="text/css">
</style>
</head>
<body>
	<form action="./actionCommentModify" method="post">
		<textarea style="vertical-align:middle; height: 100px; width: 500px;" name="content" placeholder="내용을 입력하세요"></textarea>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>