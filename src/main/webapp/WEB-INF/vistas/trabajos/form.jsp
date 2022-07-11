<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<c:if test="${trabajoForm.id > 0}">
		<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Trabajo
			N ${trabajoForm.id}</h2>
	</c:if>
	<c:if test="${trabajoForm.id == null}">
		<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Trabajo
			nuevo</h2>
	</c:if>

</div>

<form:form method="POST" action="/trabajo/guardar"
	modelAttribute="trabajoForm">
	<div class="container mt-4">

		<c:if test="">
			<div class="form-group">
				<label>Id trabajador</label>
				<form:input path="id" cssClass="form-control" readonly="true" />
			</div>
		</c:if>
		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Tarea a realizar</label>
			<form:input path="tarea" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Fecha del inicio</label>
			<form:input path="fecha" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Horas de duracion estimada</label>
			<form:input path="horasEstimadas" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Ingrese Ubicacion</label>
			<form:input path="ubicacionBo" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Seleccione Trabajador</label>
			<form:select path="trabajadorBo" items="${trabajadores}"
				itemLabel="nombre" itemValue="id" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Ingrese Horas Estimadas</label>
			<form:input path="horasEstimadas" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Seleccione primer material</label>
			<form:select path="material" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" />
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> 
				<input type="number" class="form-control" id="primero">
			</div>
		</div>
		<div class="form-group">
			<label>Seleccione segundo material</label>
			<form:select path="material" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" />
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> 
				<input type="number" class="form-control" id="primero">
			</div>
		</div>
		<div class="form-group">
			<label>Seleccione tercer material</label>
			<form:select path="material" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" />
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> 
				<input type="number" class="form-control" id="primero">
			</div>
		</div>
		<div class="form-group">
			<h2 class="p-2">Total a pagar</h2>
			<form:input path="precioFinal" cssClass="form-control" readonly="true" />
			<button class="btn btn-primary mt-3" id="boton">Calcular costo</button>
			
		</div>



		<button type="submit" class="btn btn-primary mt-2">Guardar Trabajo Nuevo</button>
	</div>
</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>