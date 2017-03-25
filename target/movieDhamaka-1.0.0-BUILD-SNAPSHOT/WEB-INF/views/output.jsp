<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Admin</title>
</head>
<body>
<h2>Here is a simple CRUD using Spring MVC and MongoDB.</h2>

		<form action="movie/save" method="post">
			<input type="hidden" name="id">
			<label for="name">Movie Name</label>
			<input type="text" id="name" name="name"/>
			<input type="submit" value="Submit"/>
		</form>

	<table border="1">
		<c:forEach var="movie" items="${movieList}">
			<tr>
				<td>${movie.name}</td><td><input type="button" value="delete" onclick="window.location='movie/delete?id=${movie.id}'"/></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>