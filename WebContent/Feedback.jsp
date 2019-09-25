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
<form action="FeedbackDetails" method="post" >
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">Fid:</div>
<div class="col-md-3"><input type="text" name="txtFid"></div>
<div class="col-md-3"></div>
</div>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">Feedback:</div>
<div class="col-md-3"><input type="text" name="txtFd"></div>
<div class="col-md-3"></div>
</div>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">User Id:</div>
<div class="col-md-3"><input type="text" name="txtUid"></div>
<div class="col-md-3"></div>
</div>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 ">Rating:</div>
<div class="col-md-3"><input type="text" name="txtRt"></div>
<div class="col-md-3"></div>
</div>
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-3 "><a href='FeedbacksDetails'><input type="submit" value="Login " name="btn"></a>

</div>

<div class="col-md-3"></div>
<div class="col-md-3"></div>

</div>

</form>
</body>
</html>