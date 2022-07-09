<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Trabajador n ${trabajador.id}</h2>
</div>
<div class="card mt-2">
	<h5 class="card-header">${trabajador.nombre}
		${trabajador.apellido}</h5>
	<div class="card-body">
		<h5 class="card-title">Telefono trabajador: ${trabajador.dni}</h5>
		<p class="card-text">DNI trabajador: ${trabajador.dni}</p>
		<p>trabajo: ${trabajador.trabajos}</p>
	</div>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>