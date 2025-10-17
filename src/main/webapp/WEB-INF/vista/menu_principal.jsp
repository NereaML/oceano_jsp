<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Oceano</title>
<link rel="stylesheet" type="text/css" href="${css}/index.css">
</head>
<body>
	<header class="cabecera">
	<h2>Menú Principal</h2>
	</header>
	<div id="contPrincipal">
		<ul> 
			<li><a href="${home}/listado_criaturas">Criaturas</a></li>
			<li><a href="${home}/alta_criatura">Crear Criatura</a></li>
			<li><a href="${home}/eliminar_criatura">Eliminar Criatura</a></li>
			
			<hr />
			<li><a href="${home}/registro_cuidador">Crear Cuidador</a></li>
			<li><a href="${home}/listado_cuidadores">Cuidadores Activos</a></li>
			<hr />
			<li><a href="${home}/informacion">Informacion</a></li>
			<hr />
			<li><a href="${home}/cerrar_sesion">Cerrar Sesion</a></li>
		</ul>
	</div>
</body> 
</html>