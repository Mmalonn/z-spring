<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value ="/js/jquery-3.6.0.js"/>"></script>
<script type="text/javascript" src="<c:url value ="/js/bootstrap.js"/>"></script>

<link href="/css/general.css" rel="stylesheet">
<link href="/css/bootstrap.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>
<body>
	<header
		class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar">

		<div class="navbar-nav-scroll">
			<ul class="navbar-nav bd-navbar-nav flex-row">
				<li class="nav-item mr-5 mt-1"><a class="nav-link" href="/"
					onclick=" "><h2 class="border primary rounded-lg">Inicio</h2></a></li>
				<li class="nav-item mt-3"><a class="nav-link active"
					href="/trabajos/lista" onclick=" "><p>
							<u>Trabajos pendientes</u>
						</p></a></li>
				<li class="nav-item mt-3"><a class="nav-link "
					href="/materiales" onclick=" "><p>
							<u>Materiales</u>
						</p></a></li>
				<li class="nav-item mt-3"><a class="nav-link"
					href="/trabajadores/lista" onclick=" "><p>
							<u>Personal</u>
						</p></a></li>
			</ul>
		</div>

		<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
			<li class="nav-item dropdown"><a
				class="nav-item nav-link dropdown-toggle mr-md-2" href="#"
				id="bd-versions" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Proveedores </a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="bd-versions">
					<a class="dropdown-item active" href="/proveedores">Proveedores</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/provedor1">Easy</a> <a
						class="dropdown-item" href="/provedor2">Sanchez Martinez</a> <a
						class="dropdown-item" href="/provedor3/">Ferrocons</a> <a
						class="dropdown-item" href="/provedor4">Sodimac</a>
				</div></li>

		</ul>

		<a
			class="btn btn-bd-download d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
			href="/terminados/lista">Trabajos Terminados</a>
	</header>
	<div>