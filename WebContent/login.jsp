<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%= "<h1>Login Page</h1>" %>
		<form action="LoginController" method="post">
			Enter UserName: <input type="text" name="username" /> <br /> Enter
			Password: <input type="password" name="password" /> <input
				type="submit" value="Login"><br /> <br />
		</form>
	</div>
	<form action="register.jsp">
		<input type="submit" name="click" value="Click to Register">
	</form>

</body>
</html>