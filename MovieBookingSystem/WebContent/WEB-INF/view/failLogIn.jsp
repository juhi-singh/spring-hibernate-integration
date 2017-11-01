<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center> <h2> Welcome To Movie Booking System </h2>
			<hr>
			<form action="/failLogIn" method="post">
			 <input type="text" name="userName" placeholder="Enter Your Name" required=""/><br><br>
			<input type="password" name="password" placeholder="Enter Password" required=""/><br><br>
			<!-- <input type="radio" name="userType" value="User"> User 
			<input type="radio" name="userType" value="Admin">Admin <br><br>   -->
			<input type="submit" value="LogIn" formaction="successfulLogIn"/> 
			 <center>
			<font color="red"><h6> Invalid Credentials </h6></font>
			
			</form>
			

</body>
</html>