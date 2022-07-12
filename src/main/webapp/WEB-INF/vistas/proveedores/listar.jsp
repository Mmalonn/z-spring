<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Proveedores</h2>
</div>

<table class="table mt-4 ">
	<thead>
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Telefono</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<c:forEach items="${proveedores}" var="p">
		<tr>
			<td scope="row">${p.nombre}</td>
			<td scope="row">${p.telefono}</td>
			<td></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>