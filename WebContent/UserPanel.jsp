<%@page import="icsd.ClsPlan"%>
<%@page import="icsd.ClsPlan"%>
<%@page import="java.util.LinkedList"%>
<%@page import="icsd.DBHandler"%>
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
<form  action='PlanDescription'>

<%
		DBHandler objDH=new DBHandler();
		LinkedList<ClsPlan> lst=objDH.getTblPlan();
%>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "></div>
<div class="col-md-3"><a href='Feedback.jsp' class="btn btn-outline-primary">Feedback</a></div>
<div class="col-md-3"></div>
</div>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "></div>
<div class="col-md-3"><a href='Status' class="btn btn-outline-primary">Requests</a></div>
<div class="col-md-3"></div>
</div>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "></div>
<div class="col-md-3">Select plan<select name='selPlansAvail'>
				<%
					for(ClsPlan obj:lst)
					{
						%>
				<option value='<%=obj.getStrPlanId()%>'><%=obj.getStrPlanName()%></option>		
						<%
					}
				%>
				
								
			</select> <br>

</div>
<div class="col-md-3"><input type='submit' value=' View Plan ' class='btn btn-danger'/></div>
</div>


</form>
</body>
</html>