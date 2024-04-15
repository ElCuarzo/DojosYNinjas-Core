<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Index</title>
</head>
<body>
	<h1>Los Ninjas que pertenecen al dojo <c:out value="${dojo.name}"></c:out></h1>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
		</tr>
		<c:forEach items="${ninjas}" var="ninja">
			<tr>
				<td><c:out value="${ninja.nombre}"></c:out></td>
				<td><c:out value="${ninja.apellido}"></c:out></td>
				<td><c:out value="${ninja.age}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/nuevo/dojo">Haz click aqui para crear un nuevo Dojo!</a>
	<br>
	<a href="/nuevo/ninja">Haz click aqui para crear un nuevo Ninja!</a>
</body>
</html>