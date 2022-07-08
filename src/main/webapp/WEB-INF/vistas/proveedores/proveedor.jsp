<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<div class="card mt-2">
	<h5 class="card-header">${proveedor.id}</h5>
	<div class="card-body">
		<h5 class="card-title">${proveedor.nombre}</h5>
		<p class="card-text">
			${proveedor.telefono}
		</p>
	</div>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>