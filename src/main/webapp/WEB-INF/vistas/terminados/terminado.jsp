<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajo
		terminado n ${terminado.id}</h2>
</div>
<div class="card mt-2">
	<h5 class="card-header">${terminado.nombre}</h5>
	<div class="card-body">
		<h5 class="card-title">${terminado.ubicacionBo}</h5>
		<p class="card-text">${terminado.tarea}</p>
	</div>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>