<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/phonebook3/edit" method="post">
		<input type="hidden" name="num" value="${person.personID}" />
		<div>
			<label for="txt-name">이름:</label> <input id="txt-name" type="text" name="name" placeholder="${person.name}">
		</div>
		<div>
			<label for="txt-hp">핸드폰:</label> <input id="txt-hp" type="text" name="hp" placeholder="${person.hp}">
		</div>
		<div>
			<label for="txt-company">회사:</label> <input id="txt-company" type="text" name="company" placeholder="${person.companyhp}">
		</div>
		<button type="submit">수정</button>
	</form>


</body>
</html>