<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>fecha</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${trabajos}" var="t">
		<tr>
			<td>${t.id}</td>
			<td>${t.nombre}</td>
			<td>${t.fecha}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>