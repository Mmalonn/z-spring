<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Trabajos</h2>
	<a class="d-inline border primary rounded-lg px-2 ml-3"
		href="/trabajos/nuevo">Agregar nuevo</a>
</div>
<div class="container">
	<table class="table mt-4 ">
		<thead>
			<tr>
				<th scope="col">Nombre</th>
				<th scope="col">Ubicacion</th>
				<th scope="col">Fecha</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trabajos}" var="t">
				<tr>
					<td scope="row">${t.nombre}</td>
					<td>${t.ubicacionBo.direccion}</td>
					<td>${t.fecha}</td>
					<td>
						<a type="button" class="btn btn-secondary btn-sm" href="/trabajos/${t.id}">Ver</a>
						<a type="button" class="btn btn-secondary btn-sm" href="/trabajos/${t.id}/eliminar/${t.trabajadorBo.id}">Eliminar</a>
						<a type="button" class="btn btn-secondary btn-sm" href="/">Terminado</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
