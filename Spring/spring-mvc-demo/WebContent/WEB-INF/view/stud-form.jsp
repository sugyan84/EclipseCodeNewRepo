<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring-MVC Form Tags</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	First name: <form:input path="firstName" />
		<br>
		<br>
	Last name: <form:input path="lastName" />
		<br>
		<br>
	
	Country: <form:select path="country">
			<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="India" label="India" />
			<form:option value="Australia" label="Australia" />
		</form:select>

		<br>
		<br>
		
		
	Choose your favourite language: <br>
		<br>
	Java <form:radiobutton path="favLang" value="Java" />
		<br>
		
	Spring <form:radiobutton path="favLang" value="Spring" />
		<br>
	DM <form:radiobutton path="favLang" value="DM" />
		<br>
	ML <form:radiobutton path="favLang" value="ML" />
		<br>
		<br>
		
		
		Choose your operating system: <br>
		<br>
	
	Linux <form:checkbox path="operatingSystem" value="Linux" /><br>
	Windows <form:checkbox path="operatingSystem" value="Windows" /><br>
	Red-Hat <form:checkbox path="operatingSystem" value="Red-Hat" /><br>
	Unix <form:checkbox path="operatingSystem" value="Unix" /><br>
		<input type="submit" value="Process Form" />
	</form:form>

	<br>
	<br>



</body>
</html>