<!DOCTYPE html >
<html>
	<body>

		<h2> <center>Welcome To Movie Booking System</center>  </h2>
			<hr>
			<form action="/registerForm" method="get">
		<center>	
			<input type="text" name="userName" placeholder="Your Full Name" required=""/><br><br>
			<input type="text" name="address" placeholder="Enter Address" required=""/><br><br>
			<input type="number" name="phoneNum" placeholder="Enter Mobile Number" required=""/><br><br>
			<input type="password" name="password" placeholder="Password" required=""/><br><br>
			<input type="radio" name="userType" value="User" required=""> User 
			<input type="radio" name="userType" value="Admin"> Admin <br><br> 
			<input type="submit" value="Register" formaction="registerMesg"/> <center>
		</form> 
	</body></html>
