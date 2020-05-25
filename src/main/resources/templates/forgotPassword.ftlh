<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

	<div class="form" >
		<div class="container">
			<br>
			<div class="row">
				<div class="col-md-8 m-auto d-block">
					<h1 class="text-success text-center">Forgot Password</h1>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-8 m-auto d-block">
					<form class="bg-light" method="post">
						<span id="password"></span>
						<br><br>
						<div class="form-group">
							<label>Enter Email</label>
							<input type="text" name="email" class="form-control" autocomplete="off" id="userEmail" >
						</div>
						
						<div class="row">
							<div class="col-4">
								<button type="submit" name="ForgotPassword" class="btn btn-success" id="forgotPassword">
									Find
								</button>
							</div>
							<div class="col-4 text-right">
								<a href="login" class="btn btn-link px-0">Back to LogIn?</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="js/ajax.js"></script>

</body>
</html>