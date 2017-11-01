<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


		<form action="/successfulLogIn" method="get">
			<center>
		<h2>Welcome To Movie Booking System</h2>
	</center>
	<font color="green"><h6> Hi ${userName}</h6></font>
	<!-- <h3><input type="submit" value="Log Out" formaction="logOut" /></h3> -->
	<hr>

	<input type="hidden" name="userName" value="${userName}" />
		<center><input type="submit" value="Select City" formaction="selectCity" /></center>



</body>
</html>