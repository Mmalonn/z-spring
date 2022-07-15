<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="m-5">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Materiales</h2>
	<c:choose>
  		<c:when test="${categorias[0] == null}">
			<p class="d-inline border secondary rounded-lg bg-secondary px-2 ml-3">Para crear material ingrese una categoria primero</p>			
  		</c:when>
  		<c:when test="${proveedores[0] == null}">
			<p class="d-inline border secondary rounded-lg bg-secondary px-2 ml-3">Para crear material ingrese un proveedor primero</p>			
  		</c:when>
  		<c:otherwise>
  			<sec:authorize access="hasRole('ADMIN')">
  				<a class="d-inline border secondary text-secondary rounded-lg px-2 ml-3" href="/materiales/nuevo">Agregar nuevo</a>
			</sec:authorize>		
  		</c:otherwise>
	</c:choose>
	<a class="border secondary  text-secondary rounded-lg px-2 ml-3 mr-3" href="/materiales/categorias">Categorias</a>
	<select id="selectMateriales"></select>
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
			<sec:authorize access="hasRole('ADMIN')">
				<td scope="row" class="flex-row-reverse"><a type="button" class="btn btn-secondary btn-sm" href="/materiales/${m.id}/comprar">Comprar mas</a></td>
			</sec:authorize>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>