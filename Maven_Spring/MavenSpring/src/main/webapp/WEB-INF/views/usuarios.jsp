<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Usuarios</title>
	</head>
	<body>
	
	
		<h1>Usuarios</h1>
		<c:forEach items="${listado}" var="usr">
			${usr.id}.
			${usr.nombre}<br />
		</c:forEach>
		
		
	</body>
</html>