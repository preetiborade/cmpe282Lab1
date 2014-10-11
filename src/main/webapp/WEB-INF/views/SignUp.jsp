<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<link rel="stylesheet" type="text/css" href="resources/bootstrap.css" >

<title>Student Information</title>
</head>

<style>
	body {
		background-image: url('resources/images/cart_on_laptop.jpg');
		background-repeat: no-repeat;
	}
</style>


<body>
<div class="container-fluid">

			<br>
			<br>
			<form action="signUp" method="post">
				First Name : <input type = "text" name = "fname"/>
				<br>
				Last Name : <input type = "text" name = "lname"/>
				<br>
				Username : <input type = "text" name = "user"/>
				<br>
				Password : <input type = "text" name = "password"/>
				<br>
				<input type = "submit" value = "submit"/>
			</form>
		
</div>
</body>


</html>