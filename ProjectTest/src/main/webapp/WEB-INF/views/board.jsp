<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	margin: 0 auto;
	width: 400px;
	border: 1px solid black;
}
</style>




</head>
<body>


	<div>
		<table>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.b_id}</td>
					<td>${item.b_subject}</td>
					<td>${item.b_contents}</td>
					<td>${item.b_date}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<c:set var="index" value="${handler.grpStartPage }" />
		<c:if test="${handler.currentGrp > 1 }">
			<a href="/testing/board?p=${index -1 }">[이전]</a>
		</c:if>
		<c:forEach begin="${index }" end="${handler.grpEndPage }" var="i">
			<a href="/testing/board?p=${i }">[${i}]</a>
		</c:forEach>

		<c:if test="${handler.grpEndPage < handler.totalPage }">
			<a href="/testing/board?p=${handler.grpEndPage+1 }">[다음]</a>
		</c:if>

	</div>

</body>
</html>