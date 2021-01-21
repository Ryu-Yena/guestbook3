<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/guestbook3/guest/delete/${no}" method="post">
		비밀번호 <input type="password" name="password">
		<button type="submit">확인</button>
		<br>
		<a href="/guestbook3/guest/addlist">메인으로 돌아가기</a>
		
		<input type="text" name="no" value="${requestScope.no}">
	</form>

</body>
</html>