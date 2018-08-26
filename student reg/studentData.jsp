<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Student Registration</title>
</head>
<body>
	<div class = "container">
		<div class = "form-group">
		<form action="Register" method="post">
			<label>Index Number:</label>
			<input class = "form-control" type="text" name ="index" placeholder="Enter Indrex"></br>
			<label>Student Name:</label>
			<input class = "form-control" type="text" name ="name" placeholder="Enter Student name"></br>
			<label>Mobile Number:</label>
			<input class = "form-control" type="text" name ="mobile" placeholder="Enter Mobile Number"></br>
			<label>Email Address:</label>
			<input class = "form-control" type="text" name ="eAddress" placeholder="Enter Email address"></br>
			<input class = "btn btn-success btn-lg" type="submit" value ="Submit" name ="Submit"> 
			</form>
		</div>			
		 <label style="color:red;">${info0}</label>
	</div>
	
	<div class = "container">
		<form action="getData" method="post">
			<label>Index Number:</label>
			<input class = "form-control" type="text" name ="index" placeholder="Enter Indrex"></br>
			<label>Student Name:</label>
			<input class = "form-control" type="text" name ="name" placeholder="Enter Student name"></br>
			<input class = "btn btn-info btn-lg" type="submit" value ="Submit" name ="Submit"> 
			</form>
			<label style="color:red;" >${info}</label>
	</div>
	
	<div class = "container" style ="font-size:14px;" >
		<dl class = "dl-horizontal">
		<dt>Index No :</dt>
		<dd>${indexNo}</dd>
		
		<dt>Student Name :</dt>
		<dd>${uName}</dd>
		
		<dt>Mobile number :</dt>
		<dd>${umobile}</dd>
		
		<dt>Email Address :</dt>
		<dd>${uemail}</dd>
		</dl>
	</div>
	
</body>
</html>