<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
div.container {
    width: 100%;
    border: 1px solid gray;   
}

header, footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

article {
    margin-left: 170px;
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
}
</style>


</head>
<body>
<div class="container">

<header>
   <h1>FlamAlert</h1>
</header>

<nav>
   <ul>
  <li><a href="#">Home</a></li>
    <li><p><a href="movie" target="_self">Movie Details</a></p></li>
    <li><a href="Admin.html">Admin</a></li>
  </ul>
  
</nav>

<article>
  <h1>Admin HomePage</h1>
  <p></p>
</article>

<footer>Copyright &copy; NRfrinds.com</footer>

</div>
</body>
</html>