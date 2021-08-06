<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My info</title>
</head>
<body>
<form action="./myInfoIdentify" method="post">
	<button>내가 작성한 글 조회</button>
	<input type="hidden" name="ano" value="${list.ano }">
</form>
<button>내가 작성한 댓글 조회</button>
	<button onclick="location.href='./myInfoModify'">수정,탈퇴</button>
</body>
</html>