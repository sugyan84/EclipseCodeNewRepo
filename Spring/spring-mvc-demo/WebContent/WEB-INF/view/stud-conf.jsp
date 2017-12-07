<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>

	<h4>Hello Mr.: ${student.lastName}</h4>

	<br>
	<br>

	<h4>You belong to: ${student.country}</h4>

	<h4>It seems your fav language is: ${student.favLang}</h4>

	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li> ${temp} </li>
		</c:forEach>
	</ul>
</body>
</html>