<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Trabajador
		N ${trabajador.id}</h2>
</div>
<div class="card mt-2">
	<h5 class="card-header">${trabajador.nombre}
		${trabajador.apellido}</h5>
	<div class="card-body">
		<h5 class="card-title">Telefono trabajador: ${trabajador.telefono}</h5>
		<p class="card-text">DNI trabajador: ${trabajador.dni}</p>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Trabajos:</th>
				</tr>
			</thead>
			<c:forEach items="${trabajos}" var="t">
				<tr>						
					<td scope="row">${t.nombre}</td>
					<td scope="row">${t.fecha}</td>					
				</tr>
			</c:forEach>	
		</table>
	</div>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>