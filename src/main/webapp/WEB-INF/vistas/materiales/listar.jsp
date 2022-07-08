<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<table class="ml-3 mt-3">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>cantidad</th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${materiales}" var="m">
			<tr>
				<td>${m.id}</td>
				<td>${m.nombre}</td>
				<td>${m.cantidad}</td>
			</tr>
		</c:forEach>
	</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>