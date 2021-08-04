<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
<style type="text/css">
#inputbox {
	vertical-align: middle;
}
</style>
<script type="text/javascript">
	function check() {
		//alert("제목과 내용을 작성해주세요");
		var title = document.getElementById("title");
		var content = document.getElementById("content");
		//alert(title.value + " : " + content.value);

		if (title.value.length < 5 || title.value == "") {
			alert("제목을 5글자 이상 작성해주세요.");
			title.focus();
			return false;//진행 멈춤
		}
		if (content.value == "" || content.value.length < 5) {
			alert("내용을 5글자 이상 작성해주세요.");
			content.focus();
			return false;
		}
		//실행
	}
</script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./summernote/summernote.min.css" rel="stylesheet">
<script src="./summernote/summernote.min.js"></script>
</head>
<body>
	<h1 style="text-align: center;">글 작성</h1>
	<hr>
	<form action="./actionBoardWrite" method="post"onsubmit="return check();" enctype="multipart/form-data">
		<div id="inputbox">
			<input type="text" id="title" name="title" placeholder="제목을 입력해주세요"
				required="required"><br>
			<textarea name="content" id="content" placeholder="내용을 입력하세요."></textarea>
			<input type="file" name="file1" accept=".gif, .png, .jpg, .jpeg">
		</div>
		<button type="submit">작성</button>
		<button onclick="location.href='./actionBord'">취소</button>
	</form>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#content').summernote({
				height : 500
			});
		});
	</script>

</body>
</html>