
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
    <title>Pet</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div>
		   <h1 class="purple"><c:out value="${pet.petName}"/></h1>
		</div>
		<div class="center-body">		
			<div class="space-between">
				<div><h2 class="sky-blue">Pet Details:</h2></div>
				<div class="links-btn">
					<h2><a href="/home">dashboard</a></h2>
				</div>
			</div>
		</div>
		<div class="details-body">
			<div class="details-left">
				<div class="detail">
					<h2>Type of animal </h2>
					<h2>- <c:out value="${pet.petType}"/></h2>
				</div>
				<div class="detail">
					<h2>Age of animal </h2>
					<h2>- <c:out value="${pet.petAge}"/></h2>
				</div>
			</div>
			<div class="details-right">
				<div class="detail">
					<h2>This pet likes </h2>
					<h2>- <c:out value="${pet.petLikes}"/></h2>
				</div>
				<div class="detail">
					<h2>This pet dislikes </h2>
					<h2>- <c:out value="${pet.petDislikes}"/></h2>
				</div>
			</div>
		</div>
		<div class="options">
			<div class="option-elmt"><a href="/pets/${pet.id}/edit">edit</a></div>
			<div class="option-elmt">
				<form action="/pets/${pet.id}" method="post">
					<input type="hidden" name="_method" value="delete">
				    <input type="submit" value="delete" class="link-button">
				</form>
			</div>
		</div>
	</div>
</body>
</html>