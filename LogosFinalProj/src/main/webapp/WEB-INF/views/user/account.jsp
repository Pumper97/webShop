<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="account">
		<div class="container"> 
			<div class="account-bottom">
				<div class="col-md-6 account-left">
					<form method="POST" >
					<div class="account-top heading">
						<h3>NEW CUSTOMERS</h3>
					</div>
					<div class="address">
						<span>First Name</span>
						<input type="text" name="fName">
					</div>
					<div class="address">
						<span>Last Name</span>
						<input type="text" name="lName">
					</div>
					<div class="address">
						<span>Email Address</span>
						<input type="text" name="email">
					</div>
					<div class="address">
						<span>Password</span>
						<input type="text" name="password">
					</div>
					
					<div class="address new">
						<input type="submit" value="submit">
					</div>
					</form>
				</div>
				<div class="col-md-6 account-left">
					<form>
					<div class="account-top heading">
						<h3>REGISTERED CUSTOMERS</h3>
					</div>
					<div class="address">
						<span>Email Address</span>
						<input type="text">
					</div>
					<div class="address">
						<span>Password</span>
						<input type="text">
					</div>
					<div class="address">
						<a class="forgot" href="#">Forgot Your Password?</a>
						<input type="submit" value="Login">
					</div>
				</div>
				</form>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
</body>
</html>