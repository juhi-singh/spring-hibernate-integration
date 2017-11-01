<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<form action="/selectMovie" method="get">
		<h2>
			<center>
				Welcome To Movie Booking System<br>
		</h2>
	<font color="green"><h6>   ${userName}</h6></font>
	<!-- <h3><input type="submit" value="Log Out" formaction="logOut" /></h3> -->
	<hr>
	
		<center>
			<table border="1">

			<!-- <b>List of Movies<br>
 -->			<tr>
				<th> List of Movies</th></tr>
				<tr><th> Name | Seat | Price</th>
				</tr>
				<tr>
					<c:forEach items="${lists}" var="item">
						<td><c:out value="${item}" /></td><td><INPUT TYPE = "radio" NAME = "movieName" VALUE =${item} required="">
						<br>
				</tr>
				</c:forEach>
				</table> <br><br><br>
</form>
		<input type="hidden" name="userName" value="${userName}" />
		 <input type="hidden" name="cityName" value="${city}" />
		  <input type="hidden" name="theaterId" value="${theaterId}" />
		<input type="number" name="seatAvailable" placeholder="Number of Seats" required=""/><br><br>
	<input type="submit" value="Submit" formaction="billPage" />
</body>
</html>