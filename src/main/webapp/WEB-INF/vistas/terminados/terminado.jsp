<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajo N ${terminado.id}</h2>
</div>
<div class="card mt-2">
	<h5 class="card-header">Cliente: ${terminado.nombre}</h5>
	<div class="card-body">
		<h5 class="card-title">Ubicacion: ${terminado.ubicacionBo}</h5>
		<p class="card-text">Tarea: ${terminado.tarea}</p>
	</div>
	<table class="table">
			<thead>
				<tr>
					<th scope="col">Trabajador: </th>
					<th scope="col">Precio: </th>
				</tr>
			</thead>
				<tr>						
					<td scope="row">${terminado.trabajadorBo}</td>
					<th>$ ${terminado.precioFinal} </th>		
				</tr>
	</table>
	
	<table class="table">
			<thead>
				<tr>
					<th scope="col">Iniciado el dia: </th>
					<th scope="col">Terminado el dia: </th>
				</tr>
			</thead>
				<tr>						
					<td scope="row">${terminado.fecha}</td>
					<th>${terminado.fechaFinalizacion} </th>		
				</tr>
	</table>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>