<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Trabajos
		terminados</h2>
</div>
<table class="table mt-4 ">
	<thead>
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Ubicacion</th>
			<th scope="col">Fecha Finalizado</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<c:forEach items="${terminados}" var="t">
		<tr>
			<td scope="row">${t.nombre}</td>
			<td scope="row">${t.ubicacionBo.nombre}</td>
			<td scope="row">${t.fechaFinalizacion}</td>
			<td scope="row" class="flex-row-reverse">
				<a type="button" class="btn btn-secondary btn-sm" href="/terminados/${t.id }">Ver</a>
			</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>