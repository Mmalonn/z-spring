<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>









<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2"> Materiales</h2>
	<a class="d-inline border secondary rounded-lg px-2 ml-3"
		href="/materiales/nuevo">Agregar nuevo</a> 

</div>
<div class="mt-2 ml-3 ">
	<a class="border secondary  text-secondary rounded-lg"
		href="/materiales/categorias">Categorias</a>
</div>

<form:form method="POST" action="/materiales/guardar" modelAttribute="materialForm">
	<div class="container mt-4">
	
		<c:if test="${materialForm.id > 0}">
			<div class="form-group">
				<label>Id material</label>
				<form:input path="id" cssClass="form-control" readonly="true"/>
			</div>
		</c:if>
		
		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label>Cantidad a comprar</label>
			<form:input path="cantidad" cssClass="form-control" id="cantidad"/>
		</div>
		<div class="form-group">
			<label>Precio</label>
			<form:input path="precio" cssClass="form-control" readonly="true"/>
		</div>
		<div class="form-group">
			<h2 class="p-2">Total a pagar     <span class="badge bg-secondary" id="total"></span></h2>
			<button class="btn btn-secondary" id="boton">Calcular costo</button>
		</div>


		<button type="submit" class="btn btn-secondary mt-2">Comprar mas en ${materialForm.proveedorBo.nombre}</button>
	</div>
</form:form>

<script type="text/javascript">

let valor = ${materialForm.precio};

document.getElementById("boton").addEventListener("click", function(e){
	let cantidad = document.getElementById("cantidad").value;
	e.preventDefault()
	document.getElementById("total").innerHTML = cantidad*valor;
	  
	});




</script>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>