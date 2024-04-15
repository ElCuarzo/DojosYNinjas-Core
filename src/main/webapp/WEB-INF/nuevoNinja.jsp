<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear nuevo Ninja</title>
</head>
<body>
	<h1>Crear nuevo Ninja</h1>
	<form action="/nuevo/ninja" method="POST">
        <label for="dojoId">Dojo al que pertenece: </label>
        <select name="dojoId" id="dojoId" required>
        	<c:forEach items="${dojos}" var="dojo">
    			<option value="${dojo.id}">${dojo.name}</option>
			</c:forEach>
        </select>
        <br>
        <label for="nombre">Nombre: </label>
        <input type="text" id="nombre" name="nombre" required>
        <br>
        <label for="nombre">Apellido: </label>
        <input type="text" id="apellido" name="apellido" required>
        <br>
        <label for="edad">Edad: </label>
        <input type="number" id="edad" name="edad" step="1" required>
        <br>
        <input type="submit" value="Crear">
    </form>
</body>
</html>