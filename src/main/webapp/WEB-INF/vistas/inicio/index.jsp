<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value ="/js/jquery-3.6.0.js"/>"></script>
<script type="text/javascript" src="<c:url value ="/js/bootstrap.js"/>"></script>

<link href="/css/general.css" rel="stylesheet">
<link href="/css/bootstrap.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>
	<header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar border  rounded-lg bg-secondary">
		<div class="navbar-nav-scroll ">
			<ul class="navbar-nav bd-navbar-nav flex-row">
				<li class="nav-item mr-5 mt-1"><a class="nav-link"><h2 class="px-3">Organizador de trabajos</h2></a></li>
			</ul>
		</div>	
	</header>
	<br><br>
	<div>
		<div class="d-block col-sm-6 text-black mt-4">
          <div class="px-5 ms-xl-4">
            <i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4" style="color: #709085;"></i>
          </div>

          <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

            <form style="width: 23rem;" method="post" action="/validar">

              <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log in</h3>

              <div class="form-outline mb-4">
                <input type="text" name="username" id="usuario" class="form-control form-control-lg" />
                <label class="form-label" for="usuario">Usuario</label>
              </div>

              <div class="form-outline mb-4">
                <input type="password" name="password" id="contraseña" class="form-control form-control-lg" />
                <label class="form-label" for="contraseña">Contraseña</label>
              </div>

              <div class="pt-1 mb-4">
                <button class="btn btn-secondary btn-lg btn-block"  type="submit">Login</button>
              </div>            
              <p>No tienes cuenta? <a href="#!" class="link-info">Crea una aqui</a></p>
            </form>
          </div>
	</div>	
</div>
	
	
	
	
</body>
</html>