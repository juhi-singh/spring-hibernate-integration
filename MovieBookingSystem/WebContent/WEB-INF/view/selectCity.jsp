
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Welcome To Movie Booking System</title>
<style>
h3{
    position: absolute;
    right: 50px;
    top: 45px;
}

</style>

</head>
<body>
	<form action="/selectCity" method="get">
		<h2>
			<center>
				Welcome To Movie Booking System<br>
		</h2><font color="green"><h6>   ${userName}</h6></font>
			<!-- <h3><input type="submit" value="Log Out" formaction="logOut" /></h3> -->
			<hr>
		
		<center>
			<table border="1" cellpadding="5">
				<caption>
					<h4>List of Cities</h4>
				</caption>
				<tr>
					<th>City Name</th>


				</tr>

				<tr>
					<c:forEach items="${lists}" var="item">
						<td><c:out value="${item}" /></td><td><INPUT TYPE = "radio" NAME = "cityName" VALUE =${item} required="">
				</tr>

				</c:forEach>
			</table>
			<br> <br>
	</form>
<input type="hidden" name="userName" value="${userName}" />
	<input type="submit" value="Submit" formaction="selectTheater" />
</body>
</html>