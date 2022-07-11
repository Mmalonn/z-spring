<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
				itemLabel="nombre" itemValue="id" cssClass="form-control" id="t"/>
		</div>
		<div class="form-group">
			<label>Ingrese Horas Estimadas</label>
			<form:input path="horasEstimadas" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Seleccione primer material</label>
			<form:select path="material" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m1"/>
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> 
				<input type="number" class="form-control" id="c1">
			</div>
		</div>
		<div class="form-group">
			<label>Seleccione segundo material</label>
			<form:select path="material" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m2"/>
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> 
				<input type="number" class="form-control" id="c2">
			</div>
		</div>
		<div class="form-group">
			<label>Seleccione tercer material</label>
			<form:select path="material" items="${materiales}" itemLabel="nombre" itemValue="Id" cssClass="form-control" id="m3"/>
			<div class="form-group">
				<label for="primero">Ingrese Cantidad</label> 
				<input type="number" class="form-control" id="c3">
			</div>
		</div>
		<div class="form-group">
			<form:input path="materiales" cssClass="form-control" id="materialesEnviar" readonly="true"/>
		</div>
		<div class="form-group">
			<h2 class="p-2">Total a pagar</h2>
			<form:input path="precioFinal" cssClass="form-control" readonly="true" />
			<button class="btn btn-primary mt-3" id="boton">Calcular costo</button>		
		</div>
		<button type="submit" class="btn btn-primary mt-2 mb-3	">Guardar Trabajo Nuevo</button>
	</div>
</form:form>

<script type="text/javascript">

document.getElementById("boton").addEventListener("click", function(e){
	e.preventDefault();
	let array = [];
		let m1 = document.getElementById("m1");
		let m2 = document.getElementById("m2");
		let m3 = document.getElementById("m3");
		let idTrabajador = document.getElementById("t").value;
		array.push(m1.value);
		array.push(m2.value);
		array.push(m3.value);
		document.getElementById("materialesEnviar").value = array;
		let trabajador = document.getElementById("t");
		console.log(idTrabajador);
		function obtenerTrabajador(){
			axios.get(`http://192.168.0.231:8080/api/trabajadores`)
			  .then((response) => {
			   	let respuesta = response.data;
			   	console.log(respuesta);
			  })
			  .catch((error) => {
			    console.log(error);
			  });
			}
		obtenerTrabajador();
		
		
	});
	
</script>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>