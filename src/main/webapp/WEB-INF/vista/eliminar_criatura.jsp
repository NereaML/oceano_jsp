<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eliminar Criatura</title>
    <link rel="stylesheet" type="text/css" href="${css}/criaturas.css">
</head>
<body>
<header class="cabecera">
    <h2>Eliminar Criatura</h2>
</header>

<div id="contPrincipal">

    <!-- Formulario de búsqueda -->
    <form action="${home}/eliminar_criatura" method="post">
        <input type="search" name="nombreComun" placeholder="Nombre de la criatura">
        <button type="submit">Buscar</button>
    </form>

    <c:if test="${not empty criaturas}">
        <table id="tabla_datos">
            <thead>
                <tr>
                    <th>Nombre común</th>
                    <th>Fecha de ingreso</th>
                    <th>Hábitat</th>
                    <th>Especie</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="criat" items="${criaturas}">
                    <tr>
                        <td>${criat.nombreComun}</td>
                        <td><fmt:formatDate value="${criat.fechaIngreso}" pattern="dd/MM/yyyy"/></td>
                        <td>${criat.habitat.nombre}</td>
                        <td>${criat.especies.nombreCientifico}</td>
                        <td>
                            <!-- Formulario para eliminar criatura -->
                            <form action="${home}/eliminar_criatura" method="post" style="display:inline;">
                                <input type="hidden" name="idCriatura" value="${criat.idCriatura}">
                                <button type="submit" onclick="return confirm('¿Seguro que quieres eliminar esta criatura?')">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- Mensaje de “no encontrado” solo si ya se buscó -->
    <c:if test="${busquedaRealizada and empty criaturas}">
        <p>No se encontraron criaturas con ese nombre.</p>
    </c:if>

    <a href="${home}/menu_principal"><button>Volver</button></a>

    <p id="error">
        <c:if test="${not empty error}">${error}</c:if>
        <c:if test="${not empty mensaje}">${mensaje}</c:if>
    </p>    

</div>
</body>
</html>

