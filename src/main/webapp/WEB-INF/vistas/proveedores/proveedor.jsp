<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border secondary rounded-lg bg-secondary px-2">Proveedor N ${proveedor.id }</h2>
</div>
<div class="card mt-2">
	<h5 class="card-header">${proveedor.nombre}</h5>
	<div class="card-body">
		<h5 class="card-title">${proveedor.direccion}</h5>
		<p class="card-text">${proveedor.telefono}</p>
			<div class="container">
				<h6 class="border-bottom">Lista de materiales</h6>
					<c:forEach items="${proveedor.materiales}" var="m">
						<p>${m.nombre}</p>
					</c:forEach>
			</div>
	</div>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>