<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<c:if test="${materialForm.id > 0}">
		<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Material N ${trabajadorForm.id}</h2>
	</c:if>
	<c:if test="${materialForm.id == null}">
		<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Material nuevo</h2>
	</c:if>
	
</div>

<form:form method="POST" action="/materiales/guardar" modelAttribute="materialForm" id="formularioMaterial">
	<div class="container mt-4">
	
		<c:if test="${materialForm.id > 0}">
			<div class="form-group">
				<label>Id material</label>
				<form:input path="id" cssClass="form-control" readonly="true"/>
				<form:errors path="id" cssClass="error"/>
			</div>
		</c:if>
		
		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control" />
			<form:errors path="nombre" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Cantidad</label>
			<form:input path="cantidad" cssClass="form-control" />
			<form:errors path="cantidad" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Precio</label>
			<form:input path="precio" cssClass="form-control" />
			<form:errors path="precio" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Categoria</label>
			<form:select path="idCategoria" items="${categorias}" itemLabel="nombre" itemValue="id" cssClass="form-control"/>
			<form:errors path="idCategoria" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Proveedor</label>
			<form:select path="idProveedor" items="${proveedores}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-categorias" />
			<form:errors path="idProveedor" cssClass="error"/>
		</div>


		<button type="submit" class="btn btn-secondary mt-2">Guardar Material</button>
	</div>
</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>