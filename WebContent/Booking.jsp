<%@page import="icsd.Booking"%>
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
</head>
<body>
<div>
<% 
String strPlanId=request.getParameter("planid");

%>
<form action="Booking?planid="<%=strPlanId %> method="post">

<div class="jumbotron">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3">User Id:</div>
<div class="col-md-3"><input type="text" name="txtUid"></div>
<div class="col-md-3"></div>
</div>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3">Plan Id:</div>
<div class="col-md-3"><input readonly name="txtPid" value=<%=strPlanId %>></div>
<div class="col-md-3"></div>
</div>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3">Persons :</div>
<div class="col-md-3"><input type="text" name="txtPrs"></div>
<div class="col-md-3"></div>
</div>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3">Booking Date:</div>
<div class="col-md-3"><input type="text" name="txtBookDate"></div>
<div class="col-md-3"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "></div>
<div class="col-md-3"></div>
<div class="col-md-3"></div>
</div>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "><a href=BookingDetails.jsp?planid=<%=strPlanId %>><input type="submit" value="Book"></a></div>
<div class="col-md-3"></div>
<div class="col-md-3"></div>
</div>
</div>
</form>
</div>


</body>
</html>