<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<div class="mt-4 ml-3">
	<h2 class="d-inline border primary rounded-lg bg-secondary px-2">
		Trabajadores
	</h2>
	<a class="d-inline border primary rounded-lg px-2 ml-3"
		href="/trabajadores/nuevo">Agregar nuevo</a>
</div>


<table class="table mt-4 ">
	<thead>
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Apellido</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<c:forEach items="${trabajadores}" var="t">
		<tr>
			<td scope="row">${t.nombre}</td>
			<td scope="row">${t.apellido}</td>
			<td scope="row" class="flex-row-reverse">
				<a type="button" class="btn btn-secondary btn-sm" href="/">Ver</a>
				<a type="button" class="btn btn-secondary btn-sm" href="/">Editar</a>
				<a type="button" class="btn btn-secondary btn-sm" href="/">Eliminar</a>
			</td>
		</tr>
	</c:forEach>
</table>




</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
