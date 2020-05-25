$(document).ready(function() {

	//Delete user from admin
	$("[id^=del]").click(function() {
		
		if (confirm('Are you sure to remove user?')) {
			
			//get button value
			var data = $(this).val();
			
			//removing the row from the data table
			var a = $('#example6').DataTable();
			a.row($(this).closest("tr")).remove();
			$(this).closest("tr").remove();
			
			$.ajax({
				type : "POST",
				url : "removeUser",
				data : {
					userId : $(this).val()
				},
				success : function(data) {
					var a = $('#example6').DataTable();
					a.draw();
					alert(data);
				},
				error : function(data) {
					alert("error");
				}
			});
		}
		else {
			var a = $('#example6').DataTable();
			a.draw();
		}
		
	});
	
	//Forgot Password
	$("#forgotPassword").click(function() {
		
		$.ajax({
			type : "POST",
			url : "findPassword",
			data : {
				userEmail : $("#userEmail").val()
			},
			success : function(data) {
				$('#password').text(data);
			},
			error : function(data) {
				$('#password').text("Some Thing Went Wrong Please Try Again...!!");
			}
		});
		return false;
	});	
	
	//Check user Existence 
	$("#Email1").blur(function(){
		
		var email = $("#Email1").val();
		var userId = $("#userId").val();
		
		alert(email);
		alert(userId);
		
		$.ajax({
			type : "POST",
			url : "checkUserExistance",
			data : {
				userEmail : email,
				userId : userId
			},
			success : function(data) {
				$('#EmailExists').text(data);
			},
			error : function(data) {
				$('#EmailExists').text("Some Thing Went Wrong with Email Id Please Try Again...!!");
			}
		});
		
	});
	
});