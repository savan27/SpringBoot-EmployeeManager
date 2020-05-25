<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	<script type = "text/javascript" >
		function preventBack(){window.history.forward();}
		setTimeout("preventBack()", 0);
		window.onunload=function(){null};
	</script>

</head>
<body>

	
	<!-- Form area -->
	<div class="form">
		<div class="container">
			<br>
			<div class="row">
				<div class="col-md-8 m-auto d-block">
					<h1 class="text-success text-center">Log-In Form</h1>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-8 m-auto d-block">
					<form class="bg-light" action="afterLogin" method="post">
						<span>${(Session.loginMsg) ! ""}</span> <br>
						<br>
						<div class="form-group">
							<label>User Name</label> 
							<input type="text" name="userName" class="form-control" autocomplete="off">
						</div>

						<div class="form-group">
							<label>Password</label> 
							<input type="password" name="password" class="form-control" autocomplete="off">
						</div>

						<span>${(Session.loginErr)!""}</span>
						<div class="row">
							<div class="col-4">
								<button type="submit" name="login" class="btn btn-success">
									Login
								</button>
							</div>
							<div class="col-4 text-right">
								<a href="forgotPassword" class="btn btn-link px-0">
									Forgot password?
								</a>
							</div>
						</div>

						<br>

						<div class="Register">
							<a href="register" class="btn btn-link px-0">
								Not Registered?Create an account 
							</a>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>