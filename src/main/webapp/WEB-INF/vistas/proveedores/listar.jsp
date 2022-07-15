<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Proveedores</h2>
	<a class="d-inline border secondary text-secondary rounded-lg px-2 ml-3" href="/proveedores/nuevo">Agregar nuevo</a>
</div>

<table class="table mt-4 ">
	<thead>
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Telefono</th>
			<th scope="col">Direccion</th>
		</tr>
	</thead>
	<c:forEach items="${proveedores}" var="p">
		<tr>
			<td scope="row">${p.nombre}</td>
			
			
			<c:if test="${p.materiales[0] == null }">
				<td scope="row">${p.telefono}
					<p class="mt-3 mr-4 border-bottom">Proveedor Vacio</p>
				</td>
				<td scope="row"><p>${p.direccion}</p>
					<a class="btn btn-secondary proveedorBorrar" href="/proveedores/${p.id}/eliminar">Borrar</a>
				</td>				
			</c:if>
			<c:if test="${p.materiales[0] != null }">
				<td scope="row">${p.telefono}</td>
				<td scope="row">${p.direccion}</td>				
			</c:if>
		</tr>
	</c:forEach>
</table>

<script type="text/javascript" src="<c:url value ="/js/botonbootbox.js"/>"></script>
<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>