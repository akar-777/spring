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
	        <h1>Match List</h1>
			<h3><a href="home">Main Menu</a></h3>
			<h3><a href="doPrediction">Predict</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>homeTeam</th>
	        	<th>awayTeam</th>
	        	<th>homeTeamGoal</th>
	        	<th>awayTeamGoal</th>
	        	<th>homeTeamPredictionGoal</th>
	        	<th>awayTeamPredictionGoal</th>
	        	<th>score</th>
	        	<th>status</th>

				<c:forEach var="match" items="${matches}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${match.homeTeam}</td>
					<td>${match.awayTeam}</td>
					<td>${match.homeTeamGoal}</td>
					<td>${match.awayTeamGoal}</td>
					<td>${match.homeTeamPreGoal}</td>
					<td>${match.awayTeamPreGoal}</td>
					<td>${match.score}</td>
					<td>${match.status}</td>
					<td>
						<a href="deleteMatch?id=${match.id}">Delete</a>
						<a href="Completion?id=${match.id}">Complete</a>
						<a href="newPrediction?id=${match.id}">Predict</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
