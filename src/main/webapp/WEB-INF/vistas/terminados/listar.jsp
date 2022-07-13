<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajos
		terminados</h2>
</div>
<div class="container ">
	<table class="table mt-4 ">
		<thead>
			<tr>
				<th scope="col">Cliente</th>
				<th scope="col">Ubicacion</th>
				<th scope="col">Fecha Finalizado</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<c:forEach items="${terminados}" var="t">
			<tr>
				<td scope="row">${t.nombre}</td>
				<td>${t.ubicacionBo}</td>
				<td>${t.fechaFinalizacion}</td>
				<td><a type="button"
					class="btn btn-secondary btn-sm" href="/terminados/${t.id }">Ver</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>