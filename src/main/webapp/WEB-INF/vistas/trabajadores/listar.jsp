<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajadores</h2>
	<a class="d-inline border secondary text-secondary rounded-lg px-2 ml-3" href="/trabajadores/nuevo">Agregar nuevo</a>
</div>


<div class="container">
<table class="table mt-4 ">
	<thead>
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Apellido</th>
			<th scope="col"></th>
			<th scope="col"></th>
			<th scope="col"></th>
		</tr>
	</thead>
	<c:forEach items="${trabajadores}" var="t">
		<tr>
			<td>${t.nombre}</td>
			<td>${t.apellido}</td>
			<td>
				<a type="button" class="btn btn-secondary btn-sm" href="/trabajadores/${t.id}">Ver</a>
			</td>
			<td>
				<a type="button" class="btn btn-secondary btn-sm" href="/trabajadores/${t.id}/editar">Editar</a>
			</td>
			<c:if test="${t.trabajos[0] == null}">
			<td>
				<a type="button" class="btn btn-secondary btn-sm eliminarTrabajador" href="/trabajadores/${t.id}/eliminar">Eliminar</a>
			</td>
			</c:if>	
			<c:if test="${t.trabajos[0] != null}">
				<td><p id="trabajador${t.id}">Asignado</p></td>				
			</c:if>
		</tr>
	</c:forEach>
</table>
</div>

<script type="text/javascript" src="<c:url value ="/js/trabajadores.js"/>"></script>
<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
