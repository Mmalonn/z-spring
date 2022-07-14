<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<c:if test="${trabajoForm.id == null}">
		<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Trabajo nuevo</h2>
	</c:if>
</div>

<script type="text/javascript">
		$(document).ready(function() {
			$('#formularioTrabajo').validate();
		});
</script>

<form:form method="POST" action="/trabajos/guardar" modelAttribute="trabajoForm" id="formularioTrabajo">
	<div class="container mt-4">

		<div class="form-group">
			<label>Cliente</label>
			<form:input path="nombre" required="true" cssClass="form-control " />
		</div>
		<div class="form-group">
			<label>Tarea a realizar</label>
			<form:input path="tarea" required="true" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Fecha del inicio</label>
			<form:input path="fecha" type="date" required="true" value="2022-01-01" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Ingrese Ubicacion</label>
			<form:input path="ubicacionBo" required="true" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Seleccione Trabajador</label>
			<form:select path="idTrabajador" items="${trabajadores}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="t" />
		</div>		
		<div class="form-group mb-4">
			<label>Ingrese Horas Estimadas</label>
			<form:input path="horasEstimadas" type="number" required="true" cssClass="form-control" id="hhoras" />
			<form:errors path="horasEstimadas" cssClass="error"/>
		</div>
		<hr><hr>			
		<div class="form-group	mt-2 pt-5 pl-5 pr-5">
			<h1 class="mb-3">Materiales</h1>
			<label class="mt-2">Seleccione primer material</label>
			<form:select path="idMaterial" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m1" />
			<div class="form-group mt-1">
				<label>Ingrese Cantidad</label>
				<input class="bg-secondary ml-3" type="number" required="true" class="form-control" id="cc1">
			</div>
		</div>			
		<div class="form-group pl-5 pr-5">
			<label>Seleccione segundo material</label>
			<form:select path="idMaterial" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m2" />
			<div class="form-group mt-1">
				<label>Ingrese Cantidad</label> 
				<input class="bg-secondary ml-3" type="number" required="true" class="form-control" id="cc2">
			</div>
		</div>
		<div class="form-group pl-5 pr-5">
			<label>Seleccione tercer material</label>
			<form:select path="idMaterial" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m3" />
			<div class="form-group mt-1">
				<label >Ingrese Cantidad</label>
				<input class="bg-secondary ml-3" type="number" required="true" class="form-control" id="cc3">
			</div>
		</div>
		<h1 hidden="true" id="noIguales">Ingrese distintos materiales</h1>
		
		
		<div class="form-group">
			<form:input path="idMateriales" id="materialesEnviar" hidden="true" readonly="true"/>
		</div>
		<div class="form-group">
			<form:input path="cantidades" id="cantidadesEnviar" hidden="true" readonly="true"/>
		</div>
		<div class="form-group">
			<form:input path="idMaterial1" id="idMaterial1" hidden="true" readonly="true"/>
		</div>
		<div class="form-group">
			<form:input path="idMaterial2" id="idMaterial2" hidden="true" readonly="true"/>
		</div>
		<div class="form-group">
			<form:input path="idMaterial3" id="idMaterial3" hidden="true" readonly="true"/>
		</div>
		<div class="form-group">
			<form:input path="cantidad1" id="cantidad1" hidden="true" readonly="true"/>
		</div>
		<div class="form-group">
			<form:input path="cantidad2" id="cantidad2" hidden="true" readonly="true"/>
		</div>
		<div class="form-group">
			<form:input path="cantidad3" id="cantidad3" hidden="true" readonly="true"/>
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
					<form:input class="alert" path="precioT" readonly="true" id="sueldoTrabajador"/>
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
					<form:input class="alert" path="precioM1" readonly="true" id="precioM1"/>
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
					<form:input class="alert" path="precioM2" readonly="true" id="precioM2"/>
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
					<form:input class="alert" path="precioM3" readonly="true" id="precioM3"/>
				</div>
				<div class="col-sm">
					<input class="alert" readonly="true" id="c3">
				</div>
			</div>
			<h1 hidden="true" id="noIguales">Ingrese distintos materiales</h1>
			<div class="row">
   			 	<div class="col-sm">
				</div>
				<div class="col-sm">		
				</div>
				<button class="btn btn-secondary mt-3 ml-5" id="boton2">Calcular total</button>	
			</div>
		</div>
		  	<button class="btn btn-secondary mt-3 mr-5 mb-5" id="boton">Calcular Previo</button>
		<div class="form-group mt-5">
		<hr><hr>	
			<h2 class="p-2 mt-3">Total a pagar</h2>
			<h1 hidden="true" id="noCero">El valor del precio a pagar no puede ser cero</h1>
			<h1 class="d-inline">$</h1>
			<form:input class="d-inline" path="precioFinal" required="true" cssClass="mt-4 ml-3 alert alert-secondary" readonly="true" id="final"/>
		</div>
		<button type="submit" class="btn btn-secondary mb-3" id="guardarTrabajoNuevo">Guardar Trabajo Nuevo</button>
	</div>
</form:form>



<script type="text/javascript" src="<c:url value ="/js/trabajo.js"/>"></script>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>