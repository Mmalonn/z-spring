<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Trabajador
		n </h2>
</div>

<form:form method="POST" action="/" >
	<div class="container mt-4">
	
		<c:if test="">
			<div class="form-group">
				<label>Id trabajador</label>
				<form:input cssClass="form-control" readonly="true"/>
			</div>
		</c:if>
		
		<div class="form-group">
			<label>Nombre</label>
			<form:input cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="precio">Apellido</label> 
			<form:input cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="precio">dni</label> 
			<form:input cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="precio">telefono</label> 
			<form:input cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="precio">Sueldo por Hora</label> 
			<form:input cssClass="form-control" />
		</div>
		

		<button type="submit" class="btn btn-primary mt-2">Guardar Trabajador</button>
	</div>
</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>