<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear Nuevo Dojo</title>
</head>
<body>
	<h1>Crear un Nuevo Dojo</h1>
	<form action="/nuevo/dojo" method=POST>
		<label for="nombre"> Nombre: </label>
		<input type="text" id="nombre" name="nombre" required>
		<br>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>