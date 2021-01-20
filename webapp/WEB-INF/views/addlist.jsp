<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="/guestbook3/guest/add" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td colspan="4"><input type="text" name="name"></td>
				<td colspan="2">비밀번호</td>
				<td colspan="4"><input type="password" name="password"></td>
			</tr>
			
			<tr>
				<td colspan="11"><textarea rows="4" cols="65" name="content"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="11"><button type="submit">확인</button></td>
			</tr>
		</table>
	</form>

	<c:forEach items="${gList}" var="gList">
		<table border="1">
			<tr>
				<td>${gList.no}</td>
				<td colspan="2">${gList.name}</td>
				<td colspan="6">${gList.reg_date}</td>
				<td colspan="2"><a href="/guestbook3/guest/deleteForm?no=${guestVo.no}">삭제</a>
			</tr>
			
			<tr>
				<td colspan="11">${gList.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>


</body>
</html>