<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Criaturas</title>
<link rel="stylesheet" type="text/css" href="${css}/alta_criatura.css">
</head>
<body>
	<header class="cabecera">
		<h2>Alta de criatura</h2>
	</header>
	
	<div id="contPrincipal">
	
		<form id="form_criatura" action="${home}/alta_criatura" method="post">
			<input id="nombreComun" type="text" name="nombreComun" placeholder="Nombre" required>
			<input id="fechaIngreso" type="text" name="fechaIngreso" placeholder="Fecha de ingreso" required>
			
			<!-- Selección de tipo de especie -->
			<select id="tipoEspecie" name="tipoEspecie" required>
				<option value="" hidden>Seleccione Tipo de Especie</option>
				<c:forEach var="tipo" items="${tiposEspecie}">
					<option value="${tipo}">${tipo}</option>
				</c:forEach>
			</select>

			<!-- Selección de hábitat -->
			<select id="idHabitat" name="idHabitat" required>
				<option value="" hidden>Seleccione Habitat</option>
				<c:forEach var="habitat" items="${habitats}">
					<option value="${habitat.idHabitat}">${habitat.nombre}</option>
				</c:forEach>
			</select>
			
			<button type="submit">Crear</button>
		</form>
	
		<a href="${home}/menu_principal"><button>Volver</button></a>
		<p id="error">
			<c:if test="${not empty error}">${error}</c:if>
			<c:if test="${not empty mensaje}">${mensaje}</c:if>
		</p>    
	</div>
</body>
</html>
