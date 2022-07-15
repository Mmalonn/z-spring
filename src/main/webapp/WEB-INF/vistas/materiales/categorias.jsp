<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Categorias</h2>
	<a class="d-inline border secondary text-secondary rounded-lg px-2 ml-3" href="/materiales/categorias/nuevo">Agregar nueva</a>
</div>
<div class="container">
	<table class="table mt-4 ">
		<thead>
			<tr>
				<th scope="col">Nombre Categoria</th>
				<th scope="col">Materiales</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categorias}" var="c">
				<tr>
				
					<td scope="row">${c.nombre}</td>
					<td>
					<c:if test="${c.materiales[0] != null }">
						<select class="form-control">
							<c:forEach items="${c.materiales}" var="m">
								<option>${m.nombre}</option>
							</c:forEach>
						</select>
					</c:if>
					<c:if test="${c.materiales[0] == null }">
						<p class="d-inline mr-4">Categoria Vacia</p>
						<a class="btn btn-secondary ml-4 d-inline categoriaBorrar" href="/materiales/categorias/${c.id}/eliminar">Borrar</a>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<script type="text/javascript" src="<c:url value ="/js/botonbootbox.js"/>"></script>
<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>