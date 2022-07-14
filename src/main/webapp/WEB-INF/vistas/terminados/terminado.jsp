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
		<p class="card-text ml-5 mb-5">Tarea: ${terminado.tarea}</p>	
		<table class="table mt-5">
				<tr>
					<th class="card-header">Trabajador: </th>
					<th class="card-header">Precio: </th>
				</tr>
				<tr>						
					<td>${terminado.trabajadorBo}</td>
					<td>$ ${terminado.precioFinal}</td>		
				</tr>			
				<tr>
					<th class="card-header">Iniciado el dia: </th>
					<th class="card-header">Terminado el dia: </th>
				</tr>			
				<tr>						
					<td>${terminado.fecha}</td>
					<td>${terminado.fechaFinalizacion} </th>		
				</tr>			
		</table>
	</div>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>