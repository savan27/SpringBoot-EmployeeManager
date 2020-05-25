<html>
<head>
<meta charset="UTF-8">
<title>profile</title>

	<!-- css -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/userprofile.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	<script type = "text/javascript" >
		function preventBack(){window.history.forward();}
		setTimeout("preventBack()", 0);
		window.onunload=function(){null};
	</script>
	
	<#include "/header.ftlh"> 

</head>
<body>

	<!-- validate session -->
	<#assign role = (Session.userRole)!"null"/>
	<#if  role != "USER"  >
		<script type="text/javascript">
		    window.location.href = "login";
		</script>
	</#if> 

	<!-- User data display starts -->
	<div class="container emp-profile">
			<form method="post">
				<div class="row">
					<div class="col-md-4">
						<div class="profile-img">
							<img src="data:image/gif;base64,${profilePicture!""}" alt="profilePhoto" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="profile-head">
							<h5>
								${(user.get().firstName)!""}
							</h5>
							<br>
							<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item">
									<a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-md-2">
						<a href="doUpdateUser?id=${(user.get().id)!""}">
							<button type="button" class="profile-edit-btn" name="btnAddMore">
								Edit Profile
							</button>
						</a>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<!-- Add something to show under the profile picture -->
				</div>
					<div class="col-md-8">
						<div class="tab-content profile-tab" id="myTabContent">
							<div class="tab-pane fade show active" id="home" role="tabpanel"
								aria-labelledby="home-tab">
								<div class="row">
									<div class="col-md-6">
										<label>First Name</label>
									</div>
									<div class="col-md-6">
										<p>
											${(user.get().firstName)!""}
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Last Name</label>
									</div>
									<div class="col-md-6">
										<p>
											${(user.get().lastName)!""}
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Email</label>
									</div>
									<div class="col-md-6">
										<p>
											${(user.get().email)!""}
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Phone</label>
									</div>
									<div class="col-md-6">
										<p>
											${(user.get().contact)!""}
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Gender</label>
									</div>
									<div class="col-md-6">
										<p>
											${(user.get().gender)!""}
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Permission</label>
									</div>
									<div class="col-md-6">
										<p>
											${(user.get().permission)!""}
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Hobby</label>
									</div>
									<div class="col-md-6">
										<p>
											${(user.get().hobbies)!""}
										</p>
									</div>
								</div>
								<br>
								 <#list user.get().address as address>
									<div class="row">
										<div class="col-md-6">
											<label>Address ${address?counter}:</label>
										</div>
										<div class="col-md-6">
											<div class="row">
												<div class="col-md-4">
													<label>House</label>
												</div>
												<div class="col-md-8">
													<p>
														${address.home!""}
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<label>Street</label>
												</div>
												<div class="col-md-8">
													<p>
														${address.street!""}
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<label>City</label>
												</div>
												<div class="col-md-8">
													<p>
														${address.city!""}
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<label>State</label>
												</div>
												<div class="col-md-8">
													<p>
														${address.state!""}
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<label>Country</label>
												</div>
												<div class="col-md-8">
													<p>
														${address.country!""}
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<label>ZipCode</label>
												</div>
												<div class="col-md-8">
													<p>
														${address.zipcode!""}
													</p>
												</div>
											</div>
										</div>
									</div>
									<hr>
								</#list> 
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		
		<#include "/footer.ftlh"> 

		<!-- script -->
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="js/popper.min.js"></script>
		<script type="text/javascript" src="js/ajax.js"></script>
		<script type="text/javascript" src="js/valid.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>