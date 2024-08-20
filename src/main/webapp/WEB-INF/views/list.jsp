<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>전화번호 리스트</h1>

    <p>입력한 정보 내역 입니다.</p>
	
	<c:forEach items = "${requestScope.personList}" var = "personVo">
    <table border = "1">
        <tr>
            <td>이름(name)</td>
            <td>${personVo.name}</td>
        </tr>
        <tr>
            <td>핸드폰(hp)</td>
            <td>${personVo.hp}</td>
        </tr>
        <tr>
            <td>회사(company)</td>
            <td>${personVo.companyhp}</td>
        </tr>
        <tr>
        	<td><a href = "">수정</a></td>
        	<td><a href = "/phonebook3/delete?num=${personVo.personID}" >삭제</a></td>
        </tr>
        <br><br>
    </table>
    </c:forEach>
    <a href = "" id="listButton">전화번호 등록</a>
    
</body>
</html>