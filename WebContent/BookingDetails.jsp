<%@page import="icsd.DBHandler"%>
<%@page import="java.util.LinkedList"%>
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
<%

String strPrs=request.getParameter("no");
String strPlanId=request.getParameter("planid");
System.out.println(strPlanId +"Hello");
HttpSession ssn =request.getSession(false);
ssn.setAttribute("prs", strPrs);
ssn.setAttribute("pln", strPlanId);
int intPrs=Integer.parseInt(strPrs);
System.out.println(strPrs);


%>

<div>
<form action="BookingDetails?planid="<%=strPlanId %> method="post">
<div class="jumbotron">
<%
for(int i=1;i<=intPrs;i++){


%>




<div class="row">
<div class="col-md-3">Person <%=i %></div>
<div class="col-md-3">First Name:</div>
<div class="col-md-3"><input type="text" name="txtFname<%=i%>"></div>
<div class="col-md-3"></div>
</div>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3">Last Name :</div>
<div class="col-md-3"><input type="text" name="txtLname<%=i%>"></div>
<div class="col-md-3"></div>
</div>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3">Age:</div>
<div class="col-md-3"><input type="text" name="txtAge<%=i%>"></div>
<div class="col-md-3"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">Gender:</div>
<div class="col-md-3"><input type="text" name="txtGnd<%=i%>"></div>
<div class="col-md-3"></div>
</div>
<br><br><br><br><br><br><br><br>

<%} %>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "><input type="submit" value="Submit"></div>
<div class="col-md-3"></div>
<div class="col-md-3"></div>
</div>
</div>
</form>
</div>

</body>
</html>