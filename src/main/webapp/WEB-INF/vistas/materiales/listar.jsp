<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border primary rounded-lg bg-secondary px-2">
		Materiales</h2>
	<a class="d-inline border primary rounded-lg px-2 ml-3"
		href="/materiales/nuevo">Agregar nuevo</a> 

</div>
<div class="mt-2 ml-3 ">
	<a class="border primary  text-secondary rounded-lg"
		href="/materiales/categorias">Categorias</a>
</div>

<table class="table mt-4 ">
	<thead>
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Proveedor</th>
			<th scope="col">Categoria</th>
			<th scope="col">Precio Unitario</th>
			<th scope="col">Stock</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<c:forEach items="${materiales}" var="m">
		<tr>
			<td scope="row">${m.nombre}</td>
			<td scope="row">${m.proveedorBo.nombre}</td>
			<td scope="row">${m.categoriaBo.nombre}</td>
			<td scope="row">${m.precio}</td>
			<td scope="row">${m.cantidad}</td>
			<td scope="row" class="flex-row-reverse"><a type="button"
				class="btn btn-secondary btn-sm" href="/">Editar</a>
			</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>