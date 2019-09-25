<%@page import="icsd.DBHandler"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<script src="js/bootstrap.min.js" ></script>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
     <style>
  .container{
  padding-top:70px;
  }         
body
{
background-image: url('66.jpg');
height: 100vh;
background-size:cover;
}</style> 
</head>

<body class="body">
<form action="AddFunction2" method="post">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">Plan Id:</div>
<div class="col-md-3"><input type="text" name="txtplnid"></div>
<div class="col-md-3"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">Plan Name:</div>
<div class="col-md-3"><input type="text" name="txtplnname"></div>
<div class="col-md-3"></div>
</div>
<div class="container">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3"></div>
<div class="col-md-3">Description:</div>
<div class="col-md-3"><input type="text" name="txtDsp"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3"></div>
<div class="col-md-3">Price:</div>
<div class="col-md-3"><input type="text" name="txtPrice"></div>
</div>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "></div>
<div class="col-md-3"></div>
<div class="col-md-3"><input type="submit" value="Add " name="btn">

	</div>
	
	
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "></div>
<div class="col-md-3"><a href='PlanList' class="btn btn-outline-primary">PlanList</a></div>
<div class="col-md-3">

	</div>
</div>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "></div>
<div class="col-md-3"></div>
<div class="col-md-3"><a href='SportList' class="btn btn-outline-primary">SportList</a>

	</div>
</div>

</div>



</form>
</body>
</html>