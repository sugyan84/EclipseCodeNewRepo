<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>

		</div>

	</div>


	<div id="container">
		<div id="content">

			<!--add customer button -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-mail</th>
					<th>Actions</th>
				</tr>

				<c:forEach var="temp" items="${customers}">

					<!--embedd the customer ids in the hyperLink  -->
					<c:url var="updateLink"  value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${temp.id}"></c:param>
					</c:url>
					
					<c:url var="deleteLink"  value="/customer/delete">
						<c:param name="customerId" value="${temp.id}"></c:param>
					</c:url>
					
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.emailAddress}</td>
						
						<td>
							<a href="${updateLink}">Modify</a>|
							<a href="${deleteLink}">Remove</a>
						</td>
					</tr>

				</c:forEach>

			</table>
		</div>

	</div>


</body>
</html>