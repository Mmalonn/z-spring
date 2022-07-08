<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar border primary rounded-lg bg-secondary">

		<div class="navbar-nav-scroll ">
			<ul class="navbar-nav bd-navbar-nav flex-row">
				<li class="nav-item mr-5 mt-1"><a class="nav-link"
					onclick=" "><h2 class="px-3">Organizador de trabajos</h2></a></li>
			</ul>
		</div>	
	</header>
	<a class="btn btn-primary btn-lg ml-5 mt-5" href="/trabajos/lista">Ingresar</an>
	
</body>
</html>