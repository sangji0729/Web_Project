<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성한 글 조회</title>
<style type="text/css">
#info{
	float: right;
}
</style>
</head>
<body>
<!-- <form action="./myInfoIdentify" method="post"> -->
<button onclick="location.href='actionInfoIdentify'">Action게시판</button>
<button onclick="location.href='dailyInfoIdentify'">Daily게시판</button>
<button onclick="location.href='dramaInfoIdentify'">Drama 게시판</button>	
<button onclick="location.href='fantasyInfoIdentify'">Fantasy 게시판</button>	
<button onclick="location.href='romanceInfoIdentify'">Romance 게시판</button>	
<button onclick="location.href='thrillerInfoIdentify'">Thriller 게시판</button>	
<div id="info">
<button>내가 작성한 댓글 조회</button>
<button>수정,탈퇴</button>
</div>
<hr>
</body>
</html>