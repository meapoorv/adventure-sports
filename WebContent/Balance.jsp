<%@page import="icsd.ClsPrice"%>
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
<%
 String strPlanId=request.getParameter("planid");
String strPrs=request.getParameter("no");
String strBal=request.getParameter("accbalance");


System.out.println(strPrs+" "+ strPlanId+" helooo"+strBal);
int intPrs=Integer.parseInt(strPrs);
DBHandler obj=new DBHandler();
ClsPrice obj1= obj.Balance(strPlanId);


String strPrice=obj1. getStrPlnPrice();
int intPrice=Integer.parseInt(strPrice);
int intbalance=intPrice*intPrs;
out.println(intbalance+"Pay this amount !!!!!!");
 


%>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3">Your Total Bill:</div>
<div class="col-md-3"><input readonly  name="txtPid" value=<%=intbalance%>></div> 
<div class="col-md-3"></div>
</div>
<%
String strbalance=String.valueOf(intbalance);

%>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "><a href=Balancecheck.jsp?bal=<%=strbalance%>&Bal=<%=strBal%>>ppppp   </a></div>
<!-- <input type="submit" value="Pay Bill"> -->
<div class="col-md-3"></div>
<div class="col-md-3"></div>
</div>

</body>
</html>