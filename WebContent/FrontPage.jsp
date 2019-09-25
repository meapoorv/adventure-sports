<%@page import="icsd.ClsPlan"%>
<%@page import="icsd.ClsSports"%>
<%@page import="java.util.LinkedList"%>
<%@page import="icsd.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>new sheet</title>
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<script src="js/bootstrap.min.js" ></script>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">     
      <style>
      .slideshow{
      margin:0 auto;
      padding-top:50px;
      height:800px;
      background:skyblue;
      box-sizing:border-box;
      }
      .content{
      margin:auto;
      width:300px;
      persrective:1000px;
      position:relative;
      padding-top:80px;
      }
      
      .content-carrousel{
      width:100%;
      position:absolute;
      float:right;
      animation:rotar 40s infinite linear;
      transform-style:preserve-3d;
      }
      .content-carrousel:hover{
      animation-play-state:paused;
      curser:pointer;
      }
      .content-carrousel figure{
      width:100%;
      height:250px;
      border:1px solid #4d444d;
      overflow:hidden;
      position:absolute;
      
      }
      
      .content-carrousel figure:nth-child(1){
      transform:rotateY(0deg) translateZ(500px);
      }
      .content-carrousel figure:nth-child(2){
      transform:rotateY(40deg) translateZ(500px);
      }
      .content-carrousel figure:nth-child(3){
      transform:rotateY(80deg) translateZ(500px);
      }
      .content-carrousel figure:nth-child(4){
      transform:rotateY(120deg) translateZ(500px);
      }
      .content-carrousel figure:nth-child(5){
      transform:rotateY(160deg) translateZ(500px);
      }
      .content-carrousel figure:nth-child(6){
      transform:rotateY(200deg) translateZ(500px);
      }
      .content-carrousel figure:nth-child(7){
      transform:rotateY(240deg) translateZ(500px);
      }
      .content-carrousel figure:nth-child(8){
      transform:rotateY(280deg) translateZ(500px);
      }
      .content-carrousel figure:nth-child(9){
      transform:rotateY(320deg) translateZ(500px);
      }
      .shadow{
      position:absolute;
      box-shadow:0px 0px 20px 0px #000;
      border-radius:2px;
      
      }
      .content-carrousel img{
      image-rendering:auto;
      translation:all 300ms;
      width:100%;
      height:100%;
      }
      .content-carrousel img:hover{
      transform:scale(1.2);
      transition:all 300ms;
      }
      @keyframes rotar{
      
      from{
      transform:rotateY(0deg);
      }to{
      transform:rotateY(360deg);
      
      }
      }
      .navbar{
     
      position:sticky;
      top:0;
      height:115px;
      padding-left:35px;
      font-size:25px;
      color:#000000;
      z-index: 500;
      }
      .navbar-brand{
      font-size:30px;
      text-align:center;
      font-family: sans-serif;
      
      }
      
      .navbar-brand1{
       
      font-size:50px;
      text-align:center;
      font-family: sans-serif;
       color:#000000;
      }
    
      .img{
      height:400px;
      width:1600px
      }
      .carousel-caption{
      font-size:80px;
      font-family:cursive
      }
   .text{
   text-align:center;
   font-size:30px;
   font-family:italic;
   color:white;
   }
   
   .body{
  background-color: #000000;
 
  
   }
   
   .fa {
  padding: 20px;
  font-size: 30px;
  width: 70px;
  text-align: center;
  text-decoration: none;
  border-radius:50%
}

/* Add a hover effect if you want */
.fa:hover {
  opacity: 0.7;
}

/* Set a specific color for each brand */


.fa-facebook {
  background: #3B5998;
  color: white;
}


.fa-twitter {
  background: #55ACEE;
  color: white;
 
}

.fa-instagram {
  background:  #f40083;
  color: white;
 
}
   
  .nav-link1{
  padding-right:30px;
   padding-left:400px;
  } 
      
      </style>
</head>
<body class="body" >

<nav class="navbar navbar-expand-lg bg-light ">
  <a class="navbar-brand1" href="#"><b>Adventure</b></a></nav>


<div id="myslider" class="carousel slide carousel-fade" data-ride="carousel">


<div class="carousel-inner" role="listbox">
 
 <div class="carousel-item active">
    <img  height="500px" width="1500px" src="77.jpg">
    <div class="carousel-caption text-warning text-right">Let's Hang Out</div>
  </div>
   
 <div class="carousel-item">
 <div class="carousel-caption">Let's Hang Out</div>
    <img height="500px" width="2000px"  src="pp.jpg">
   
</div> 


</div>
<a class="carousel-control-prev" href="#myslider" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#myslider" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
  
  
   <ol class="carousel-indicators">
      <li data-target="#myslider" data-slide-to="0" class="active"></li>
      <li data-target="#myslider" data-slide-to="1"></li>
     
   </ol>



</div>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Adventure</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About Us</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Quick Tour
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <div class='container'>
        <!-- <form action='Sports'> -->
        <form action='Sports'>

<%
		DBHandler objDH=new DBHandler();
		
		LinkedList<ClsSports> lstSports=objDH.getTblSports();





	
		for(ClsSports obj:lstSports)
		{
			%>
		<input type='submit' value='<%=obj.getStrSportname()%>' name='txtUnm'> <br>
			<%
		}
	
	%>

</form>
</li>
      
        <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Login As
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="Admin.jsp">Admin</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="Login.jsp">User</a>
          
          
        </div>
      </li>
    
    </ul>
    
    
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<pre class="text">    Get your board, bike, motorcycle, scooter, skates, ski's, 
     or whatever and hit that rail or ramp. Even if you just grind a curb
     or roll mellow it's all good. LIVE, LOVE, DREAM, and most of all be EXTREME!!!
     PEACE OUT FOR NOW! BOOKMARK this site & Contact us below and watch us grow.
                        THANX 4 YOUR SUPPORT!</pre>



<selection class="slideshow">
<div class="content">
<div class="content-carrousel">
<figure class="shadow"><img src="11.jpg"></figure>
<figure class="shadow"><img src="22.jpg"></figure>
<figure class="shadow"><img src="33.jpg"></figure>
<figure class="shadow"><img src="44.jpg"></figure>
<figure class="shadow"><img src="55.jpg"></figure>
<figure class="shadow"><img src="66.jpg"></figure>
<figure class="shadow"><img src="aa.jpg"></figure>
<figure class="shadow"><img src="pp.jpg"></figure>
<figure class="shadow"><img src="ww.jpg"></figure>

</div>
</div>
</selection><br><br><br><br><br><br><br><br><br><br><br><br>

<pre class="text">    Get your board, bike, motorcycle, scooter, skates, ski's, 
     or whatever and hit that rail or ramp. Even if you just grind a curb
     or roll mellow it's all good. LIVE, LOVE, DREAM, and most of all be EXTREME!!!
     PEACE OUT FOR NOW! BOOKMARK this site & Contact us below and watch us grow.
                        THANX 4 YOUR SUPPORT!</pre>
                        
                        
                        <pre class="text">    Get your board, bike, motorcycle, scooter, skates, ski's, 
     or whatever and hit that rail or ramp. Even if you just grind a curb
     or roll mellow it's all good. LIVE, LOVE, DREAM, and most of all be EXTREME!!!
     PEACE OUT FOR NOW! BOOKMARK this site & Contact us below and watch us grow.
                        THANX 4 YOUR SUPPORT!</pre>
                        
                        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar" href="#">Adventure</a>
  <a href="facebook.com" class="fa fa-facebook"></a><br>
<a href="#" class="fa fa-twitter"></a>
<a href="https://instagram.com/imapoorv07?igshid=ymvdr6c3zrxo" class="fa fa-instagram"></a>
<li class="nav-item">
        <a class="nav-link1" href="FeedbackTable" tabindex="-1" aria-disabled="true">Reviews</a>
      </li>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

</body>
</html>
