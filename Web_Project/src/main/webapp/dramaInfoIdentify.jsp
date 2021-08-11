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
a:link {
	text-decoration: none;
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
	height: 1000px;
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
	margin-bottom: 10px;
	text-align: center;
}
#boardreturnbtn{
	float: right;
	vertical-align: middle;
	margin-bottom: 10px;
	margin-left: 20px;
	height: 30px;
	width: 150px;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">Drama 게시판 작성한 글 조회</h1>
	<hr>
	<c:import url="./myinfomenu.jsp" />
<div id="mainWrapper">
<c:choose>
<c:when test="${fn:length(list) > 0 }">
		<ul id="ulTable">
			<li>
				<ul>
					<li>게시판</li>
					<li>제목</li>
					<li>글쓴이</li>
					<li>날짜</li>
					<li>조회수</li>
				</ul>
			</li>
			<c:forEach items="${list }" var="l">
				<li>
					<ul>
						<li>${l.dno }</li>
						<li><a href="./dramaDetail?dno=${l.dno }">
						 <c:choose>
									<c:when test="${l.dthumbnail eq null }">
										<img alt="no image" src="./img/noimage.jpg"
											style="vertical-align: middle; height: 100px;">
									</c:when>
									<c:otherwise>
										<img alt="thumb" src="./thumbnail/${l.dthumbnail }"
											style="vertical-align: middle; height: 100px;">
											</c:otherwise>
								</c:choose>
						</a> <a href="./dramaDetail?ano=${l.dno }">${l.dtitle } <c:if
									test="${l.commentcount > 0}">
									<small> [ 댓글수 : ${l.commentcount } ]</small>
								</c:if>
								<c:if test="${l.dlike > 0 }">
								<small>[ 추천수 : ${l.dlike } ]</small>
								</c:if>
						</a></li>
						<li>${l.name }</li>
						<li>${l.ddate }</li>
						<li>${l.dcount }</li>
					</ul>
				</li>
				<hr>
				<br>
			</c:forEach>
		</ul>
		</c:when>
		<c:otherwise>출력할 글이 없습니다.</c:otherwise>
		</c:choose>
				<button id="boardreturnbtn" onclick="location.href='./index'">메인메뉴로 돌아가기</button>
	</div>
			<div id="paging">
				<!-- 이동할 때 마다 페이지명을 변수처리 -->
				<c:set var="pageName" value="dramaInfoIdentify" scope="request" />
				<c:set var="PAGENUMBER" value="5" scope="request"></c:set>
				<!-- 페이징 설정/변수생성 구문 모두 다 여기로 이동시킵니다 -->
				<c:import url="paging.jsp" />

				<!-- 전체페이지 : ${totalPage } / 페이지 : ${page } / 시작 : / 끝 :<br> -->

			</div>

</body>
</html>