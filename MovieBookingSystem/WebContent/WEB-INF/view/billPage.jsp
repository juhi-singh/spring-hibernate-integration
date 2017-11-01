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
<head>
<title>Welcome To Movie Booking System</title>
</head>
<body>
	<form action="/billPage" method="get">

		<h2>
			<center>
				Welcome To Movie Booking System<br>
		</h2>
		<font color="green"><h6>${userName}</h6></font>
		<h3>
			<input type="submit" value="Log Out" formaction="logOut" />
		</h3>
		<hr>
		<center>
			<font color="green"><h5>Booking Successful</h5></font> <font><tr>
					<td><h5>
							Movie Name = ${name}
							<h5>
								Price = ${price}
								</h4>
								<h5>
									Number of Seats = ${seat}

									<h5>
										----------------------------------------------------------------<br>
										<h5>
											Total Price = ${bill}
											</h4>
											<br>
											<br>

										<!-- 	<button type="submit" value="Print" formaction="printTicket">Print</button></font> -->
</body>
</html>