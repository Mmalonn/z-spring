<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<div class="container">
		<h1>Factura de ${factura.nombre}</h1>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Id producto</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Cantidad</th>
					<th>Subtotal</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="tbody-productos">
			</tbody>
		</table>
		<form>
			<div class="form-row mb-2 mt-4">
				<div class="col-6">
			
				</div>
				<div class="col-2">
					<p class="alert alert-primary" id="cantidadTotal"></p>
				</div>
				<div class="col-2">
					<p class="alert alert-primary" id="total"></p>
				</div>
				<div class="col-2">
						
				</div>
			</div>
		</form>
		<div class="container" id="mensaje">
		</div>
	</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>