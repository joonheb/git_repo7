<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<script type="text/javascript" src="../script/boardScript.js?v=1"></script>
</head>
<body>
<form action="boardWrite.do" method="post" name="boardWriteForm">
	<table border="1">
		<tr>
			<th width="50">제목</th>
			<th><input type="text" name="subject" size="59"></th>
		</tr>
		<tr>
			<th width="50">내용</th>
			<th><textarea rows="15" cols="45" name="content"></textarea></th>
		</tr>
		<tr>
			<th colspan="2" align="center">
				<input type="button" value="글 쓰기" onclick="checkBoardWrite()">
				<input type="reset" value="다시 작성">
			</th>
		</tr>
	</table>
</form>
</body>
</html>