<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<c:if test="${trabajadorForm.id > 0}">
		<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajador N ${trabajadorForm.id}</h2>
	</c:if>
	<c:if test="${trabajadorForm.id == null}">
		<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajador nuevo</h2>
	</c:if>
	
</div>

<script type="text/javascript">
		$(document).ready(function() {
			$('#formularioTrabajador').validate();
		});
</script>

<form:form method="POST" action="/trabajadores/guardar" modelAttribute="trabajadorForm" id="formularioTrabajador" enctype="multipart/form-data">
	<div class="container mt-4">
	
		<c:if test="${trabajadorForm.id > 0}">
			<div class="form-group">
				<label>Id trabajador</label>
				<form:input path="id" cssClass="form-control" readonly="true"/>
			</div>
		</c:if>
		
		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" required="true" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Apellido</label> 
			<form:input path="apellido" required="true"  cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Dni</label> 
			<form:input path="dni" required="true" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Telefono</label> 
			<form:input path="telefono" required="true"  cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Sueldo por Hora</label> 
			<form:input path="sueldoPorHora" required="true" cssClass="form-control" />
			<form:errors path="sueldoPorHora" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Ingrese foto del trabajador</label>
			<input type="file" name="foto" class="form-control">
		</div>

		<button type="submit" class="btn btn-secondary mt-2">Guardar Trabajador</button>
	</div>
</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>