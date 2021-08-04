<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style type="text/css">
#mainWrapper{
	margin: 0 auto;
	margin-top: 10px;
	margin-right: 70px;
	margin-bottom: 30px;
	height: 716px auto;
	width: 1100px;
	float: right;
	background-color: rgb(26, 188, 156);
	border-radius: 5px;
}
table {
	margin: 0 auto;
	min-height: 300px;
	height: 600px;
	width: 1100px;
	border-collapse: collapse;
	margin-bottom: 20px;
	border-color: white;
}
table td{
	padding-left:20px; 
}
table tr:last-child{
	height: 200px;
}
#title{
	height: 30px;
}
#id{
	height: 30px;
}
#date{
	height: 30px;
}
#count{
	height: 20px;
}
#content{
	height: 100px;
}
#boardcontent{
	vertical-align: top;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">상세보기</h1>
	<div id="main">
	<div id="mainWrapper">
		<div id="detail">
			<table border="1">
				<tr>
					<th id="title">제목</th>
					<td>${list.atitle }</td>
				</tr>
				<tr>
					<th id="id">작성자</th>
					<td>${list.name }(${list.id })</td>
				</tr>
				<tr>
					<th id="date">쓴날짜</th>
					<td>${list.adate }</td>
				</tr>
				<tr>
					<th id="count">조회수</th>
					<td>${list.acount }</td>
				</tr>
				<tr>
					<th id="content">내용</th>
					<td id="boardcontent">${list.acontent }<br>
					<c:if test="${list.afilename ne null }">
					<img alt="img" src="./upload/${list.afilename }" width="50%">
					</c:if>
					 </td>
				</tr>
			</table>
<div id="comment">
	<c:choose>
			<c:when test="${list.commentcount > 0}">			
				${list.commentcount }개의 댓글이 있습니다 <br><hr>
			</c:when>
			<c:otherwise>
				댓글이 없습니다. 댓글을 달아주세요.<br>
			</c:otherwise>
		</c:choose>
		<!-- 여기에 댓글 찍기 -->
		<c:choose>
			<c:when test="${fn:length(commentList) > 0 }">
				<c:forEach items="${commentList }" var="i">
					<button>${i.acno } / ${i.name }(<small>${i.id }</small>)</button>
					${i.acdate }
					<div class="modifyBox">
						<div class="modifyInput">
					 		수정하기
					 		<div class="acontent">${i.accontent }</div>
					 		<div class="ano" style="display: none;">${i.ano }</div>
					 		<div class="acno" style="dis;ay: none;">${i.acno }</div>
					 	</div>
					 </div>
					 <hr>
				</c:forEach>	
			</c:when>
			<c:otherwise>
				댓글이 없습니다.
			</c:otherwise>
		</c:choose>
		<c:if test="${sessionScope.id ne null }">
		<div class="commentWrite">댓글을 작성하려면 클릭하세요.▼</div>
		</c:if>
		<div id="commentInput">
			<form action="./actionComment" method="post">
				<textarea name="content"></textarea>
				<input type="hidden" name="ano" value="${list.acno }">
				<button>댓글 작성</button>
			</form>
		</div>
</div>
			<button id="boardreturn" onclick="location.href='./actionBoard'">게시판으로</button>
		</div>	

	</div>
</div>

</body>
</html>