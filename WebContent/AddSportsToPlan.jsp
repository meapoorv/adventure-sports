<%@page import="icsd.ClsSports"%>
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
<div class='container'>

<%
		DBHandler objDH=new DBHandler();
		LinkedList<ClsPlan> lst=objDH.getTblPlan();
		LinkedList<ClsSports> lstSports=objDH.getTblSports();
%>
<form action='q1' >

Select plan<select name='selPlansAvail'>
				<%
					for(ClsPlan obj:lst)
					{
						%>
				<option value='<%=obj.getStrPlanId()%>'><%=obj.getStrPlanName()%></option>		
						<%
					}
				%>
				
								
			</select> <br>

Available Sports are : - <br>

	<%
		for(ClsSports obj:lstSports)
		{
			%>
			<input type='checkbox' name='chk' value='<%=obj.getStrSportId()%>'/><b><%=obj.getStrSportname() %></b>   <%=obj.getStrLocation() %> <%=obj.getStrImage() %><br>
			<%
		}
	
	%>

<input type='submit' value='Add Selected Sports to Plan ' class='btn btn-danger'/>
</form>
</div>
</body>
</html>