<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Team List</h1>
	        <h3><a href="newTeam">New Team</a></h3>
			<h3><a href="home">Main Menu</a></h3>
	        <table border="1">
	        	<th>No</th>
				<th>Id</th>
	        	<th>Name</th>
	        	<th>City</th>
	        	<th>ShortName</th>
	        	<th>Action</th>
	        	
				<c:forEach var="match" items="${teams}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${match.id}</td>
					<td>${match.name}</td>
					<td>${match.city}</td>
					<td>${match.shortName}</td>
					<td>
						<a href="editTeam?id=${match.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteTeam?id=${match.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
