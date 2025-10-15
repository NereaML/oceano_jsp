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
<link rel="stylesheet" type="text/css" href="${css}/criaturas.css">
</head>
<body>
	<header class="cabecera">
	<h2>Busqueda de criaturas</h2>
	
	</header>
	
	<div id="contPrincipal">
	
		<form action = "${home}/listado_criaturas" method = "post">
			<input type = "search" name = "nombreComun">
			<button type = "submit">Buscar</button>
		</form>
		
		<c:if test="${not empty criaturas}">
		
			<table id="tabla_datos">
				<thead> 
				<tr>
			
					<th> Nombre común</th>
					<th> Fecha de ingreso</th>
					<th> Habitat</th>
					<th> Especie</th>
			
				</tr>
				</thead>
				<tbody>
			
					<c:forEach var="criat" items="${criaturas}"> 
						<tr>
							<td>${criat.nombreComun}</td>
							<td><fmt:formatDate value="${criat.fechaIngreso}" pattern="dd/MM/yyyy"/></td>
							<td>${criat.habitat.nombre}</td>
							<td>${criat.especies.nombreCientifico}</td>
						</tr>
				
					</c:forEach>
				
				
						
				
			</tbody>
		
			</table>
		</c:if>
		
		<a href = "${home}/menu_principal"><button>Volver</button></a>
	</div>
	
	
	
	
</body>
</html>