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
String strbalance=request.getParameter("bal");
int intbal=Integer.parseInt(strbalance);

String strBal=request.getParameter("Bal");
int intBalance=Integer.parseInt(strBal);

System.out.println(strBal+"hellloooo");
int intleft=intBalance-intbal;





%>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3">New balance:</div>
<div class="col-md-3"><input type="text" name="txtBookDate" value=<%=intleft %>></div>
<div class="col-md-3"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "><a href=FrontPage.jsp><input type="submit" value="Home"></a></div>
<div class="col-md-3"></div>
<div class="col-md-3"></div>
</div>
</body>
</html>