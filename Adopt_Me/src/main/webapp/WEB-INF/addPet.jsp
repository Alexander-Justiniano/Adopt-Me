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
    <title>Add New Pet</title>
    <link rel="stylesheet" href="/CSS/style.css">
<body>
	<div class="center-form">
		<div class="space-between" id="header">
			<div>
			   <h1>New Pet</h1>
			</div>
			<div class="links-btn large-text">
				<a href="/home">dashboard</a>
			</div>
		</div>
		<div class="center-body">
			<form:form method="post" action="/createPet" modelAttribute="newPet">
				<div class="error-container"><form:errors path="petName"/></div>
				<div class="form-field">
					<div><form:label path="petName">Pet Name:</form:label></div>
					<div><form:input type="text" path="petName"></form:input></div>
				</div>
				<div class="error-container"><form:errors path="petType"/></div>
				<div class="form-field">
					<div><form:label path="petType">Pet Type:</form:label></div>
					<div><form:input type="text" path="petType"></form:input></div>
				</div>
				<div class="error-container"><form:errors path="petAge"/></div>
				<div class="form-field">
					<div><form:label path="petAge">Pet Age:</form:label></div>
		   			<div><form:input type="number" path="petAge"></form:input></div>
				</div>
				<div class="error-container"><form:errors path="petLikes"/></div>
				<div class="form-field">
					<div><form:label path="petLikes">Likes:</form:label></div>
		   			<div><form:textarea path="petLikes" rows="5" cols="60" class="text-area"></form:textarea></div>
				</div>
				<div class="error-container"><form:errors path="petDislikes"/></div>
				<div class="form-field">
					<div><form:label path="petDislikes">Likes:</form:label></div>
		   			<div><form:textarea path="petDislikes" rows="5" cols="60" class="text-area"></form:textarea></div>
				</div>
				<input type="hidden" name="user" value="<%=session.getAttribute("user_id")%>">
				<div class="element-margin" id="submit-btn">
	   				<div class="button-space">			   		
		   				<div><input class="submit-btn" type="submit" value="Submit"></div>
	   				</div>
				</div>
			</form:form>
		</div>		
	</div>
</body>
</html>