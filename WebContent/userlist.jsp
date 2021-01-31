<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration-details</title>
</head>
<body>
	<form action="login.jsp" method="post">
		<div align="center">
			<%="<h4>Congratulation! You have successfully registered. <h4>"%>

			<h4>Here is your profile:</h4>
			<table>

				<tr>
					<th>first name</th>
					<th>last name</th>
					<th>email</th>
					<th>username</th>
					<th>password</th>
					<th>gender</th>
					<th>hobby</th>
					<th>country</th>
				</tr>

				<tr>
					<td>${user.fName}</td>
					<td>${user.lname}</td>
					<td>${user.email}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.gender}</td>
					<td>${user.hobby}</td>
					<td>${user.country}</td>
				</tr>

			</table>
			<br /> <br /> <input type="submit" name="click"
				value="click here to get back to login page">
		</div>
	</form>
</body>

</html>