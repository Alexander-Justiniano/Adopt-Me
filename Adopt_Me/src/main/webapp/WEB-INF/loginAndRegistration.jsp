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
    <title>Adopt Me</title>
    <link rel="stylesheet" href="/CSS/style.css">
</head>
<body>
	<div class="container">
		<div id="centered-title">
		   <h1 class="purple">Adopt Me!</h1>
		</div>
		<div>
		   <form:form method="post" action="/register" modelAttribute="newUser">
		   
			   <table>
			   		<thead>
						 <tr>
				           <th colspan="2">Register</th>
					     </tr>
					</thead>
					<tbody>				
				   		<tr>
				   			<td><form:label path="userName">Username:</form:label>
				   				<form:errors path="userName"/>
				   			</td>
				   			<td><form:input type="text" path="userName"></form:input></td>
				   		</tr>
				   		<tr>
				   			<td><form:label path="email">Email:</form:label>
				   				<form:errors path="email"/>
				   			</td>
				   			<td><form:input type="email" path="email"></form:input>
				   			</td>
				   		</tr>
				   		<tr>
				   			<td><form:label path="password">Password:</form:label>
				   				<form:errors path="password"/>
				   			</td>
				   			<td><form:input type="password" path="password"></form:input></td>
				   		</tr>
				   		<tr>
				   			<td><form:label path="confirm">Confirm Password:</form:label>
				   				<form:errors path="confirm"/>
				   			</td>
				   			<td><form:input type="password" path="confirm"></form:input></td>
				   		</tr>
				   		<tr>
				   			<td colspan="2"><input class="submit-btn" type="submit" value="Register"></td>
				   		</tr>
					</tbody>
				</table>		
			</form:form>
		</div>   
		
		<div>
			<form:form method="post" action="/login" modelAttribute="newLogin">
			
				   <table>
				   		<thead>
							 <tr>
					           <th colspan="2">Log In</th>
						     </tr>
						</thead>
						<tbody>				
					   		<tr>
					   			<td><form:label path="email">Email:</form:label>
					   				<form:errors path="email"/>
					   			</td>
					   			<td><form:input type="email" path="email"></form:input></td>
					   		</tr>
					   		<tr>
					   			<td><form:label path="password">Password:</form:label>
					   				<form:errors path="password"/>
					   			</td>
					   			<td><form:input type="password" path="password"></form:input></td>
					   		</tr>
					   		<tr>
					   			<td colspan="2"><input class="submit-btn" type="submit" value="Log In"></td>
					   		</tr>
						</tbody>
					</table>
				
			</form:form>
		</div>
	</div>
</body>
</html>