<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<div class="container mt-4 l-3">
		<h1>Factura de ${factura.nombre}</h1>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Items</th>
					<th></th>
					<th>Precio unitario</th>
					<th>Cantidad</th>
					<th>Subtotal</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="tbody-productos">
				<tr>
					<th>Trabajo de: <b>${factura.trabajadorBo}</b> X hora</th>
					<th></th>
					<th id="p1">${factura.precioT}</th>
					<th id="c1">${factura.horasEstimadas}</th>
					<th id="t1"></th>
					<th></th>
				</tr>
				<tr>
					<th>${factura.material1}</th>
					<th></th>
					<th id="p2">${factura.precioM1}</th>
					<th id="c2">${factura.cantidad1}</th>
					<th id="t2"></th>
					<th></th>
				</tr>
				<tr>
					<th>${factura.material2}</th>
					<th></th>
					<th id="p3">${factura.precioM2}</th>
					<th id="c3">${factura.cantidad2}</th>
					<th id="t3"></th>
					<th></th>
				</tr>
				<tr>
					<th>${factura.material3}</th>
					<th></th>
					<th id="p4">${factura.precioM3}</th>
					<th id="c4">${factura.cantidad3}</th>
					<th id="t4"></th>
					<th></th>
				</tr>
			</tbody>
		</table>
		<form>
			<div class="form-row mb-2 mt-4">
				<div class="col-6">
			
				</div>
				<div class="col-2">
					<p class="alert alert-primary" id="cantidadTotal">Precio Total</p>
				</div>
				<div class="col-2">
					<p class="alert alert-primary" id="total">${factura.precioFinal }</p>
				</div>
				<div class="col-2">
						
				</div>
			</div>
		</form>
		<div class="container" id="mensaje">
		</div>
	</div>

<script type="text/javascript" src="<c:url value ="/js/factura.js"/>"></script>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>