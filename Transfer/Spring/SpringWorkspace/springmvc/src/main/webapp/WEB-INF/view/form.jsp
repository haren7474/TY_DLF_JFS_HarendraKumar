<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${name}</h2>
	<h2>${email}</h2>
	<h2>${password}</h2>
	<h2>${gender}</h2>


	<h1>Submit the below form</h1>
	<form action="./form" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="M">Male</td>
				<td><input type="radio" name="gender" value="F">Female</td>
			</tr>

			<tr>
				<td><input type="reset" value="reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>


	</form>
</body>
</html>