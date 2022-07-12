<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<c:if test="${trabajoForm.id == null}">
		<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Trabajo nuevo</h2>
	</c:if>

</div>

<form:form method="POST" action="/trabajos/guardar" modelAttribute="trabajoForm">
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
			<label>Ingrese Ubicacion</label>
			<form:input path="ubicacionBo" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Seleccione Trabajador</label>
			<form:select path="idTrabajador" items="${trabajadores}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="t" />
		</div>
		<div class="form-group">
			<label>Ingrese Horas Estimadas</label>
			<form:input path="horasEstimadas" cssClass="form-control" id="hhoras" />
		</div>
		<div class="form-group">
			<label>Seleccione primer material</label>
			<form:select path="idMaterial" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m1" />
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> <input type="number" class="form-control" id="cc1">
			</div>
		</div>
		<div class="form-group">
			<label>Seleccione segundo material</label>
			<form:select path="idMaterial" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m2" />
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> <input type="number" class="form-control" id="cc2">
			</div>
		</div>
		<div class="form-group">
			<label>Seleccione tercer material</label>
			<form:select path="idMaterial" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m3" />
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> <input type="number" class="form-control" id="cc3">
			</div>
		</div>
		
		
		
		
		<div class="form-group">
			<form:input path="materiales" id="materialesEnviar" readonly="true"/>
		</div>




		<div class="container" hidden="true" id="cont">
 			 <div class="row border-bottom">
 				<div class="col-sm">
 			 	</div>
   			 	<div class="col-sm">
     		 		<input class="alert" readonly="true" value="Precios Unitarios">
				</div>
				<div class="col-sm">
					<input class="alert" readonly="true" value="Cantidades">
				</div>
			</div>
			<div class="row">
				<div class="col-sm">
					<input class="alert" readonly="true" value="Precio Trabajador x hora">
 			 	</div>
   			 	<div class="col-sm">
					<input class="alert" readonly="true" id="sueldoTrabajador">
				</div>
				<div class="col-sm">
					<input class="alert" readonly="true" id="horas">
				</div>
			</div>
			<div class="row">
				<div class="col-sm">
					<input class="alert" readonly="true" value="Precio material 1">
 			 	</div>
   			 	<div class="col-sm">
					<input class="alert" readonly="true" id="precioM1">
				</div>
				<div class="col-sm">
					<input class="alert" readonly="true" id="c1">
				</div>
			</div>
			<div class="row">
				<div class="col-sm">
					<input class="alert" readonly="true" value="Precio material 2">
 			 	</div>
   			 	<div class="col-sm">
					<input class="alert" readonly="true" id="precioM2">
				</div>					
				<div class="col-sm">
					<input class="alert" readonly="true" id="c2">
				</div>
			</div>
			<div class="row">
				<div class="col-sm">
					<input class="alert" readonly="true" value="Precio material 3">
 			 	</div>
   			 	<div class="col-sm">
					<input class="alert" readonly="true" id="precioM3">
				</div>
				<div class="col-sm">
					<input class="alert" readonly="true" id="c3">
				</div>
			</div>
			<div class="row">
   			 	<div class="col-sm">
				</div>
				<div class="col-sm">		
				</div>
				<button class="btn btn-primary mt-3 ml-5" id="boton2">Calcular total</button>	
			</div>
		</div>
		  	<button class="btn btn-primary mt-3 mr-5" id="boton">Calcular Previo</button>

		<div class="form-group">
			<h2 class="p-2 mt-3">Total a pagar</h2>
			<h1 class="d-inline">$</h1>
			<form:input class="d-inline" path="precioFinal" cssClass="mt-4 ml-3 alert alert-primary" readonly="true" id="final"/>
		</div>
		<button type="submit" class="btn btn-primary mb-3">Guardar Trabajo Nuevo</button>
	</div>
</form:form>


<script type="text/javascript" src="<c:url value ="/js/trabajo.js"/>"></script>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>