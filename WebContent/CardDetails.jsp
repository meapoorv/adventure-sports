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
HttpSession ssn =request.getSession(false);
ssn.setAttribute("pln", strPlanId);
ssn.setAttribute("no", strPrs);
%>
<form action="CardDetails" method="post" >

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">Name on Card:</div>
<div class="col-md-3"><input type="text" name="txtUnm"></div>
<div class="col-md-3"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">Card No:</div>
<div class="col-md-3"><input type="text" name="txtNo"></div>
<div class="col-md-3"></div>
</div>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3"></div>
<div class="col-md-3">CVV:</div>
<div class="col-md-3"><input type="text" name="txtCvv"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3"></div>
<div class="col-md-3">Expiry Date :</div>
<div class="col-md-3"><input type="text" name="txtEx"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3"></div>
<div class="col-md-3">Balance :</div>
<div class="col-md-3"><input type="text" name="txtBal"></div>
</div>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "></div>
<div class="col-md-3"></div>
<div class="col-md-3"><input type="submit" value="Pay" name="btn">

</div>

</div>


</form>

</body>
</html>