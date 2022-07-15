<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<c:if test="${categoriaForm.id == null}">
		<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Nueva Categoria</h2>
	</c:if>
	
</div>

<script type="text/javascript">
		$(document).ready(function() {
			$('#formularioCategoria').validate();
		});
</script>

<form:form method="POST" action="/materiales/categorias/guardar" modelAttribute="categoriaForm" id="formularioCategoria">
	<div class="container mt-4">		
		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" required="true" cssClass="form-control" />
		</div>



		<button type="submit" class="btn btn-secondary mt-2">Guardar Categoria</button>
	</div>
</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>