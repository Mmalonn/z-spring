<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajo N ${trabajo.id}</h2>
</div>
<div class="card mt-2">
	<h5 class="card-header">Cliente: ${trabajo.nombre}</h5>
	<div class="card-body">
		<h5 class="card-title">Ubicacion: ${trabajo.ubicacionBo.direccion}</h5>
		<p class="card-text ml-5 mb-5">Tarea: ${trabajo.tarea}</p>
		<p class="card-text ml-5 mb-3">Correo: ${trabajo.correo}</p>
		<table class="table ">
			<thead>
				<tr>
					<th class="card-header" scope="col">Materiales:</th>
				</tr>
			</thead>
			<c:forEach items="${trabajo.materiales}" var="t" >
				<tr>						
					<td scope="row">${t}</td>			
				</tr>
			</c:forEach>	
		</table>
		<table class="table">
			<thead>
				<tr>
					<th scope="col" class="card-header" >Trabajador: </th>
					<th scope="col" class="card-header" >Fecha de inicio: </th>
				</tr>
			</thead>
				<tr>						
					<td scope="row">${trabajo.trabajadorBo.nombre} ${trabajo.trabajadorBo.apellido}</td>
					<th scope="row">${trabajo.fecha}</th>					
				</tr>
		</table>
	</div>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>