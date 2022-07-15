<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajos</h2>
	<c:choose>
  		<c:when test="${materiales[3] == null}">
			<p class="d-inline border secondary rounded-lg bg-secondary px-2 ml-3">Para guardar ingrese mas materiales</p>			
  		</c:when>
  		<c:when test="${trabajadores[0] == null}">
			<p class="d-inline border secondary rounded-lg bg-secondary px-2 ml-3">Para guardar ingrese un Trabajador</p>			
  		</c:when>
  		<c:otherwise>
			<a class="d-inline border secondary text-secondary rounded-lg px-2 ml-3" href="/trabajos/nuevo">Agregar nuevo</a>
  		</c:otherwise>
	</c:choose>
</div>
<div class="container">
<div class="table responsive">
	<table class="table user table-hover mt-4 ">
		<thead>
			<tr>
				<th>Cliente</th>
				<th>Ubicacion</th>
				<th>Fecha</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
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
					</td>
					<td>
						<a type="button" class="btn btn-secondary btn-sm eliminarTrabajo" href="/trabajos/${t.id}/eliminar/${t.trabajadorBo.id}">Eliminar</a>
					</td>
					<td>
						<a type="button" class="btn btn-secondary btn-sm" href="/trabajos/${t.id}/terminar/${t.trabajadorBo.id}"}">Terminado</a>
					</td>
					<td>
						<a type="button" class="btn btn-secondary btn-sm" href="/trabajos/factura/${t.factura.id}"}">Ver Factura</a>
					</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>

<script type="text/javascript" src="<c:url value ="/js/botonbootbox.js"/>"></script>
<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
