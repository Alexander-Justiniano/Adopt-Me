<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adopt Me Dashboard</title>
    <link rel="stylesheet" href="/CSS/style.css">
<body>
	<div class="container">
			<div>
			   <h1 class="purple">Welcome, <c:out value="${userName}."/></h1>
			</div>
	<div class="center-body">		
		<div class="space-between">
			<div><h2 class="sky-blue">Pets up for adoption:</h2></div>
			<div class="links-btn">
				<h2><a href="/logout">log out</a></h2>
			</div>
		</div>
		<table class="display-table">
			<tr>
				<th>ID</th>
				<th>Animal Name</th>
				<th>Animal Type</th>
			</tr>
			<c:forEach var="pet" items="${pets}">	
				<tr>
					<td><c:out value="${pet.id}"/></td>
					<td><a href="/pets/${pet.id}"><c:out value="${pet.petName}"/></a></td> 
					<td><c:out value="${pet.petType}"/></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<form action="/pets/new" method="get">
				<button class="new-pet-btn">Add a new pet</button>
			</form>
		</div>
	  </div>
	</div>
</body>
</html>