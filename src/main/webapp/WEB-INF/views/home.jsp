<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Movie Dhamaka</title>
	 <link type="text/css" href="resources/menu.css" rel="stylesheet" />
	 <script type="text/javascript" src="resources/scripts/jquery.js"></script>
	  <link href="resources/moviestyle.css" rel="stylesheet" type="text/css"/>
	    <link href="resources/thumbnail-slider.css" rel="stylesheet" type="text/css"/>
	      <script src="resources/scripts/thumbnail-slider.js" type="text/javascript"></script>
	       <script type="text/javascript" src="resources/scripts/menu.js"></script>
	<style>
	
	#scrollarea-invalid {
overflow-y: scroll;
height: 550px;
margin-left:auto;
    margin-right:auto;
}
#scrollarea-content{
  min-height:101%;
}

.labelHeading { 
   color: white;
font-weight: bold;
display: block;
width: 150px;
float: left;
}

.one {
    width: 60%;
    position: relative;
    display:inline-block;
}

	</style>
	
</head>
<body>
<div class="container">
<!-- <h1>
	Movie Dhamaka
</h1>

 <P>  The time on the server is ${serverTime}. </P> 

<p>
		<a href="movie">Click here</a> to try out Person CRUD with MongoDB
	</p>
	<nav>
   <ul>
    <li><p><a href="movie" >Movies</a></p></li>
    <li><a href="Admin.html">Admin</a></li>
  </ul>
  
</nav> -->



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
              
            <section>
                <div id='scrollarea-invalid' style="width:90%;margin:auto">
                <div id='scrollarea-content'>
                 <c:forEach var="movie" items="${movieList}">
                	<ul>
                		<li>
                		<div>
                			<h3><a href="movie/details?name=${movie.name}">${movie.name}</a></h3>
                			<div class="one"><label class="labelHeading" >Story Line:</label> <p>${movie.storyLine}</p></div>
                			<div class="one"><label class="labelHeading" >Rating:</label> <label>${movie.rating}</label></div>
                			<div class="one"><label class="labelHeading" >Released Year:</label><label>${movie.year}</label></div>
                			</div>
                		</li>
                	</ul>
                  
 			</c:forEach>
 			</div>
                </div>
            </section>
            
             <footer class="block " >
               <div class="foot"> <h3 style="color:white">Copyright &copy; 2016 </h3></div>
              
               
          
           </footer>
            
            </div>
	
	</div>
</body>
</html>
