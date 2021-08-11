<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션</title>
<style type="text/css">
a:link {
	text-decoration: none;
}

#writebtn {
	float: right;
	margin-bottom: 10px;
	margin-left: 20px;
	width: 100px;
	height: 30px;
}

#boardlist {
	margin: 0 auto;
	padding: 0;
	min-height: 800px auto;
	width: 1200px;
	vertical-align: middle;
	margin-bottom: 20px;
	border: 1px solid;
}

ul, li {
	padding: 0;
	margin: 0 auto;
	list-style: none;
	text-align: center;
}

#ulTable {
	height: 800px;
	width: 1200px;
}

#ulTable>li:first-child>ul>li {
	background-color: #26FFDF;
	padding-top: 10px;
	font-weight: bold;
	text-align: center;
	vertical-align: middle;
	height: 30px;
}

#ulTable>li>ul {
	clear: both;
	padding: 0 auto;
	position: relative;
	min-width: 40px;
}

#ulTable>li>ul>li {
	float: left;
	padding-top: 13px;
	font-size: 13pt;
	border-bottom: 1px solid gray;
	height: 100px;
}

#ulTable>li>ul>li:first-child {
	width: 10%;
}

#ulTable>li>ul>li:first-child+li {
	width: 45%;
}

#ulTable>li>ul>li:first-child+li+li {
	width: 20%;
}

#ulTable>li>ul>li:first-child+li+li+li {
	width: 15%;
}

#ulTable>li>ul>li:first-child+li+li+li+li {
	width: 10%;
}
#paging{
	margin: 0 auto;
	padding: 0;
	vertical-align: middle;
	text-align: center;
	margin-bottom: 10px;
}
</style>

</head>
<body>
	<h1 style="text-align: center;">글 검색</h1>
	<hr>
	<br>

	<c:if test="${sessionScope.id eq null }">
		<button onclick="location.href='./login.jsp'">로그인하기</button>
	</c:if>
	<c:if test="${sessionScope.id ne null }">
		<button onclick="location.href='./logout'">로그아웃</button>
		<div>
		<button onclick="location.href='./myinfomenu.jsp'">My Info</button>
		
		</div>
	</c:if>
	
	<hr>
	<div id="mainWrapper">
	<c:choose>
	<c:when test="${fn:length(list) > 0 }">
		<ul id="ulTable">
			<li>
				<ul>
					<li>번호</li>
					<li>제목</li>
					<li>글쓴이</li>
					<li>날짜</li>
					<li>조회수</li>
				</ul>
			</li>
			<c:forEach items="${list }" var="l">
				<li>
					<ul>
						<li>${l.ano }</li>
						<li><a href="./actionBoardDetail?ano=${l.ano }">
						 <c:choose>
									<c:when test="${l.athumbnail eq null }">
										<img alt="no image" src="./img/noimage.jpg"
											style="vertical-align: middle; height: 100px;">
									</c:when>
									<c:otherwise>
										<img alt="thumb" src="./thumbnail/${l.athumbnail }"
											style="vertical-align: middle; height: 100px;">
										
											</c:otherwise>
								</c:choose>
						</a> <a href="./actionBoardDetail?ano=${l.ano }">${l.atitle } <c:if
									test="${l.commentcount > 0}">
									<small> [ 댓글수 : ${l.commentcount } ]</small>
								</c:if>
								<c:if test="${l.alike > 0 }">
								<small>[ 추천수 : ${l.alike } ]</small>
								</c:if>
						</a></li>
						<li>${l.name }</li>
						<li>${l.adate }</li>
						<li>${l.acount }</li>
					</ul>
				</li>
				<hr>
				<br>
			</c:forEach>
			<c:if test="${sessionScope.id ne null }">
				<button id="writebtn" onclick="location.href='./actionBoardWrite'">글작성</button>
			</c:if>
			
		</ul>
		</c:when>
		<c:otherwise>출력할 글이 없습니다</c:otherwise>
		</c:choose>
		<div id="searchdiv">
			<form action="./actionBoardSearch" method="post">
				<select name="search">
					<option value="atitle"
						<c:out value="${requestScope.search == 'atitle'? 'selected':''}"/>>제목</option>
					<option value="acontent"
						<c:out value="${requestScope.search == 'acontent'? 'selected':''}"/>>내용</option>
					<option value="name"
						<c:out value="${requestScope.search == 'name'? 'selected':''}"/>>이름</option>
					<option value="id"
						<c:out value="${requestScope.searchC == 'id'? 'selected':''}"/>>아이디</option>
				</select>
				<c:choose>
					<c:when test="${empty requestScope.searchInput}">
						<input type="text" id="search" name="searchInput">
					</c:when>
					<c:otherwise>
						<input type="text" id="search" name="searchInput"
							value="${requestScope.searchInput}">
					</c:otherwise>
				</c:choose>

				<button type="submit">검색</button>
			</form>
			<button onclick="location.href='actionBoard'">게시판으로 돌아가기</button>
		</div>
	</div>
			<div id="paging">
				<!-- 이동할 때 마다 페이지명을 변수처리 -->
				<c:set var="pageName" value="actionBoard" scope="request" />
				<c:set var="PAGENUMBER" value="5" scope="request"></c:set>
				<!-- 페이징 설정/변수생성 구문 모두 다 여기로 이동시킵니다 -->
				<c:import url="paging.jsp" />

				<!-- 전체페이지 : ${totalPage } / 페이지 : ${page } / 시작 : / 끝 :<br> -->

			</div>


</body>
</html>