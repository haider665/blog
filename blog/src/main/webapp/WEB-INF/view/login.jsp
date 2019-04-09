<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
	<title>travel home page </title>
	<meta charset="utf-8"></meta>
	  <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/travelhome.css"></link>
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
	   			<form:form class="form" action="processLogin" 
	   					method="POST">
	   				

	   				<div class="loginform">Account Login</div>

	   				<div class="email">
	   					<input type="email" class="inputstyle" placeholder="Enter Email" name="email"></input>
	   				</div>
	   				
	   				<div class="email nxt">
	   					<input type="password" class="inputstyle" placeholder="Enter Password" name="password"></input>
	   				</div>

	   				<div class="button">
	   					<button class="btn">Sign in</button>
	   				</div>

	   				<div class="text-center">
	   					<span class="text1">Forgot</span>
	   					<a href="#" class="text2">Username/Password?</a>
	   				</div>

	   				<div class="text-centersignup">
	   					<span class="text1">Creat an account?</span>
	   					<a href="signup" class="text2">Sign up</a>
	   				</div>
	   				
	   			</form:form>
	   			
	   		</div>
	   	
	   </div>
	</div>
</body>
</html>
    
    