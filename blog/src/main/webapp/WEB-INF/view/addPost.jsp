<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Home</title>
	  <meta charset="utf-8"></meta>
	  <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styleForNothing.css"></link>
	  <link href="https://fonts.googleapis.com/css?family=Text+Me+One" rel="stylesheet">
	  <link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet">
<style>
.error {
	color: red
}
</style>	  
</head>
<body>

   <!-- <div class="topnav">
   		
        <a href="registrform.html" class="signup">Sign Up</a>
        
        <a href="#news" class="logoalign"><img src="img4.jpg" class="navlogoforamj"></img></a>
        
        <h1 class="heading">Ahmadiyya Muslim Jamaat</h1>
  
   </div>
 -->
	<div class="backgroundImage">
		
	   <div class="container">

	   		<div class="loginbox">
	   			<form:form action="${link}" modelAttribute="post" class="form" enctype="multipart/form-data">
	   				

	   				<div class="loginform"></div>

	   				<div class="email"> <form:errors path="title" cssClass="error" /> <br>
	   					<form:input type="text" class="inputstyle" placeholder="Title" name="email" path="title"/>
	   				</div>

	   				<div class="email"> <font color="red">${errorFile}</font> <br> 
	   					<form:input style="padding: 20px 20px 5px 23px;" type="file" class="inputstyle" path="postImage" placeholder="Enter Email" name="image"/>
	   				</div>

	   				<div class="email">
	   					
						<div class="custom-select" style="width:200px;"> <font color="red">${errorMessage}</font> <br>
						  <form:select path="category">  
						    <option value="0">Select Category:</option>
						    <option value="Travel">Travel</option>
						   
						  </form:select>
						</div>
	   				</div>
	   				
	   				<div class="email">  <form:errors path="post" cssClass="error" /> <br>
	   					<form:textarea placeholder="Write Description" path="post" name="description"/>
	   				</div>
					<input type="hidden" name = "email" value="${email }"/>
	   				<div class="button">
	   					<button class="btn">Submit</button>
	   				</div>

	   				
	   				
	   			</form:form>
	   			
	   			
	   		</div>
	   	
	   </div>
	</div>



</body>
</html>