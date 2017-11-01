<!DOCTYPE html >

<html>
<head>
<title>Welcome To Movie Booking System</title>
<style>
h3 {
    position: absolute;
    right: 50px;
    top: 45px;
}

</style>

</head>
<body>
	<form action="/errorSeats" method="get">
			<h2>
			<center>
				Welcome To Movie Booking System<br>
		</h2><font color="green"><h6>   ${userName}</h6></font><hr>
		<h3><input type="submit" value="Log Out" formaction="logOut" /></h3>
		
	<center>	<font color="red"><h5> SORRY!! </h5></font>
	<font color="red"><h5> Seats not Available. Please try Again </h5></font>
		
	</form>
	<input type="hidden" name="userName" value="${userName}" />
	<input type="submit" value="back" formaction="selectCity" />
</body>
</html>