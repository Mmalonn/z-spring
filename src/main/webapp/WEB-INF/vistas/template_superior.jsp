<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value ="/js/jquery-3.6.0.js"/>"></script>
<script type="text/javascript" src="<c:url value ="/js/bootstrap.js"/>"></script>
<script type="text/javascript" src="<c:url value ="/js/jquery.validate.js"/>"></script>
<script type="text/javascript" src="<c:url value ="/js/messages_es_AR.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/select2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/materiales.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/bootbox.all.js"/>"></script>



<link href="<c:url value="/css/select2.min.css"/>" rel="stylesheet" >
<link href="/css/general.css" rel="stylesheet">
<link href="/css/bootstrap.css" rel="stylesheet">
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<meta charset="ISO-8859-1">
<style>
span.error{
	color: red;
	font-weight:bold;
}
label.error{
	color: red;
	font-weight:bold;
}

</style>
<title>z-Spring</title>
</head>
<body>
	<header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar border secondary rounded-lg bg-secondary">
		<div class="navbar-nav-scroll ">
			<ul class="navbar-nav bd-navbar-nav flex-row">
				<li class="nav-item mr-5 mt-1">
					<a class="nav-link" href="/trabajos/lista">
						<h2 class="border secondary rounded-lg px-3">Inicio</h2>
					</a>
				</li>
				<li class="nav-item mt-3">
					<a class="nav-link" href="/trabajos/lista">
						<p>
							<u>Trabajos pendientes</u>
						</p>
					</a>
				</li>
				<li class="nav-item mt-3">
					<a class="nav-link " href="/materiales/lista">
						<p>
							<u>Materiales</u>
						</p>
					</a>
				</li>
				<li class="nav-item mt-3">
					<a class="nav-link" href="/trabajadores/lista">
						<p>
							<u>Personal</u>
						</p>
					</a>
				</li>
				<sec:authorize access="isAuthenticated()">
				<li class="nav-item mt-3">
					<a class="nav-link" href="/logout">
						<p>
							<u>Cerrar sesion</u>
						</p>
					</a>
				</li>
				</sec:authorize>
			</ul>
		</div>

		<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
			<li class="nav-item dropdown"><a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Proveedores </a>
				<div class="dropdown-menu dropdown-menu-right " aria-labelledby="bd-versions">
					<a class="dropdown-item active bg-secondary" href="/proveedores">Proveedores</a>
					<div class="dropdown-divider"></div>
					<c:forEach items="${proveedores}" var="p">
						<a class="dropdown-item" href="/proveedores/${p.id}">${p.nombre}</a>
					</c:forEach>
				</div>
			</li>
		</ul>

		<a class="btn btn-bd-download d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="/terminados/lista">Trabajos Terminados</a>
	</header>
	<div>