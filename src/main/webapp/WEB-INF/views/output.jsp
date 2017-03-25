<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Admin</title>

 <link type="text/css" href="resources/menu.css" rel="stylesheet" />
	 <script type="text/javascript" src="resources/scripts/jquery.js"></script>
	  <link href="resources/moviestyle.css" rel="stylesheet" type="text/css"/>
	    <link href="resources/thumbnail-slider.css" rel="stylesheet" type="text/css"/>
	      <script src="resources/scripts/thumbnail-slider.js" type="text/javascript"></script>
	       <script type="text/javascript" src="resources/scripts/menu.js"></script>
<style>

input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

#scrollarea-invalid {
overflow-y: scroll;
height: 450px;
margin:auto;
}

input[type=numeric], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

textarea {
    width: 100%;
    height: 80px;
    padding: 12px 20px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    background-color: #f8f8f8;
    font-size: 16px;
    resize: none;
}

input[type=submit]:hover {
    background-color: #45a049;
}

#formdiv {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 10px;
    width:90%;
    margin-left: 0.7cm;
}

table {
    border-collapse: collapse;
    width: 100%;
    background-color: #f2f2f2
}

th, td {
    text-align: left;
    padding: 8px;
}



th {
    background-color: #4CAF50;
    color: white;
}

.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 12px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 12px;
    margin: 4px 2px;
    cursor: pointer;
}

.button3 {border-radius: 8px;}
</style>
</head>
<body>

<div id="container" class="gradientBack1">

 <header>
                <div class="title" style="background-image: url(resources/images/mBg.jpg)">
                    <h1 style="color:white;">
                    Movie Dhamaka
                    </h1>
                    
                 </div>
                <div id="menu">
                    <ul class="menu">
                        </li>
                       
                        <li class="last"><a href="/"><span>All Movies</span></a></li>
                        <li class="last"><a href="movie"><span>Admin</span></a></li>
                    </ul>
                </div>
            </header>
<div id='scrollarea-invalid'>
<div style="display:inline;">
<h3>Add Movies:</h2>
		<form action="movie/save" method="post">
		<div id="formdiv">
			<input type="hidden" name="id">
			
			<label for="name">Movie Name</label>
    <input type="text" id="name" name="name">

    <label for="year">Released Year</label>
    <input type="numeric" id="year" name="year">

   <label for="rating">Rating</label>
    <input type="numeric" id="rating" name="rating">
    
    <label for="storyLine">Story Line</label>
   <textarea id="storyLine" name="storyLine"></textarea>
		
		<!-- 	<label for="name">Movie Name</label>
			<input type="text" id="name" name="name"/> -->
			<input type="submit" value="Submit"/>
</div>
</form>
</div>
<div style="display:inline;" >
<h3>Movies added: </h3>
	<table border="1">
	 <tr>
    <th>Name</th>
    <th>Rating</th>
    <th>Released Year</th>
    <th>StoryLine</th>
    <th>Operation</th>
  </tr>
		<c:forEach var="movie" items="${movieList}">
			<tr>
				<td>${movie.name}</td>
				<!-- <td>${movie.id}</td> -->
				<td>${movie.rating}</td>
				<td>${movie.year}</td>
				<td>${movie.storyLine}</td>
				<td>
				<input type="button" value="update" class="button button3" onclick="window.location='movie/update?id=${movie.id}'"/>
				<input type="button" value="delete" class="button button3" onclick="window.location='movie/delete?id=${movie.id}'"/></td>
			</tr>
		</c:forEach>
	</table>
	</div>	
	</div>
	</div>
</body>
</html>