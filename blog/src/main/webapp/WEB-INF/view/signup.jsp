<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
	<title>travel home page </title>
	<meta charset="utf-8"></meta>
	  <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/travelsignup.css"></link>
	  <link href="https://fonts.googleapis.com/css?family=Text+Me+One" rel="stylesheet">
	  <link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet">
</head>
<body>
	<div class="backgroundImage">
		<div class="hero-text">
		    <h1 style="font-size:70px">Discover the world</h1>
		    <p style="font-size:40px">Welcome to This Page</p>
		    <!-- <button>Sign Up</button> -->
		</div>
	   <div class="container">

	   		<div class="loginbox">
	   			<form:form class="form" modelAttribute="user" action="processSignup">
	   				

	   				<div class="loginform">Sign Up</div>

	   				<div class="email">
	   					<form:input type="text" class="inputstyle" placeholder="Enter Username" name="username" path="userName"></form:input>
	   				</div>

	   				<div class="email nxt">
	   					<form:input type="email" class="inputstyle" placeholder="Enter Email" name="email" path="email"></form:input>
	   				</div>
	   				
	   				<div class="email nxt">
	   					<form:input type="password" class="inputstyle" placeholder="Enter Password" name="email" path="password"></form:input>
	   				</div>

	   				<div class="button">
	   					<button class="btn">Sign up</button>
	   				</div>
	   				
	   			</form:form>
	   			
	   		</div>
	   	
	   </div>
	</div>
</body>
</html>    