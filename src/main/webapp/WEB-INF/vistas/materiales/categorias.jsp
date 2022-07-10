<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>
<div class="mt-4 ml-3">
	<h2 class="d-inline border primary rounded-lg bg-secondary px-2">Categorias</h2>
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
						<select class="form-control">
							<c:forEach items="${c.materiales}" var="m">
								<option>${m.nombre}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>