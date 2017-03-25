<%@ page session="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail of Movie</title>
 <link type="text/css" href="resources/menu.css" rel="stylesheet" />
	 <script type="text/javascript" src="resources/scripts/jquery.js"></script>
	  <link href="resources/moviestyle.css" rel="stylesheet" type="text/css"/>
	    <link href="resources/thumbnail-slider.css" rel="stylesheet" type="text/css"/>
	      <script src="resources/scripts/thumbnail-slider.js" type="text/javascript"></script>
	       <script type="text/javascript" src="resources/scripts/menu.js"></script>
</head>
<body>
<h2>Here is a simple CRUD using Spring MVC and MongoDB.</h2>

	
 
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
                       
                        <li class="last"><a href="movie"><span>All Movies</span></a></li>
                        <li class="last"><a href="movie"><span>Admin</span></a></li>
                    </ul>
                </div>
            </header>
            <section>
	<table border="1">
	
			<tr>
				<td><div><label>Name: </label>${name}</div></td>
				<td><div><label>Rating: </label>${rating}</div></td>
				<td><div><label>StoryLine: </label>${storyLine}</div></td>
				<td><div><label>Released Year: </label>${year}</div></td>
				<td>${rating}</td>
				
				<!-- <td><input type="button" value="delete" onclick="window.location='movie/delete?id=${movie.id}'"/></td>
			 --></tr>
	
	</table>
	
	 	<form action="comment/save" method="post">
			<input type="hidden" name="movieName">
			<label for="name">Comments Name</label>
			<input type="text" id="user" name="user"/>
			<input type="text" id="review" name="review"/>
			<input type="submit" value="Submit"/>
		</form>
 
	
	<!-- Add Comments -->
	
	<c:forEach var="comment" items="${comments}">
                	<ul>
                		<li>
                		<div>
                			
                			<div class="one"><label class="labelHeading" >User:</label> <p>${user}</p></div>
                			<div class="one"><label class="labelHeading" >Comment:</label> <label>${review}</label></div>
                			
                			</div>
                		</li>
                	</ul>
                  
 			</c:forEach>
	
	</section>
	  <footer class="block " >
               <div class="foot"> <h3 style="color:white">Copyright &copy; 2016 </h3></div>
              
               
          
           </footer>
	</div>	
</body>
</html>