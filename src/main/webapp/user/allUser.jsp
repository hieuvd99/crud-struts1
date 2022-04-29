<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All User</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div align="center">
			<h1>ALL USER</h1>
			<html:link page="/add-user.do">Create new User</html:link>
			<logic:empty name="listUser">
				<p>Empty User</p>
			</logic:empty>
			<logic:notEmpty name="listUser">
				<div class="table-responsive">
					<table border="1" cellpadding="10">
						<tr>
							<th>ID</th>
							<th>User name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<logic:iterate id="user" name="listUser">
							<tr>
								<td><bean:write name="user" property="id" /></td>
								<td><bean:write name="user" property="username" /></td>
								<td><bean:write name="user" property="phone" /></td>
								<td><bean:write name="user" property="email" /></td>
								<td><html:link page="/edit-user.do" paramId="userId" paramName="user" paramProperty="id">Edit</html:link></td>
								<td><html:link page="/delete-user.do" paramId="userId" paramName="user" paramProperty="id">Delete</html:link></td>
							</tr>

						</logic:iterate>
					</table>
				</div>
			</logic:notEmpty>
		</div>
	</div>
</body>
</html>