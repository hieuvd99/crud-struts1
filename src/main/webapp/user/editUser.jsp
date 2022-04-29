<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div align="center">
			<h1>Edit User</h1>
			<html:link page="/all-user.do">All User</html:link>

			<html:form action="/edit-user-post.do" method="post">
				<html:hidden property="id" name="user" />
				<table border="0" cellpadding="10">
					<tr>
						<td>User Name:</td>
						<td><html:text property="username" name="user"></html:text></td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td><html:text property="phone" name="user"></html:text></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><html:text property="email" name="user"></html:text></td>
					</tr>
					<tr>
						<td><html:submit>Save</html:submit></td>
					</tr>
				</table>
			</html:form>
			<br>
			<html:errors property="user.name.required" />	
			<br>
			<html:errors property="user.phone.required" />
			<br>
			<html:errors property="user.email.required" />	
			<br>
			<logic:present name="message-editUser">
				<bean:write name="message-editUser" />
			</logic:present>
		</div>
	</div>
</body>
</html>