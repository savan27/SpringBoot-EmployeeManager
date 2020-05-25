$(document).ready(function() {
	
	var wrapper = $(".new_address_wrap"); //Fields wrapper
	var str = 2;
	
	//initialize New Address count
	var x = str-1;
	
	//initialize Remove Address count
	var y = str-1; 
	
	$("[id^=addAddress]").click(function(e){ //on add input button click
		
			e.preventDefault();
			
			x++; //text box increment
			
			y++; //new address count
			
			//add input box
			$(wrapper).append(
					
					'<div class="addressDiv${data.AddressId}">'+
					'<br>'+
					'<div class="form-group">'+
						'<label>Address '+x+':</label>'+
						'<span style="float: right;" id="addAddress"><i class="fa fa-plus"></i></span>'+
						'<pre style="float: right;"> | </pre>'+
						'<span style="float: right;" id="removeAddress"><i class="fa fa-minus"></i></span>'+
						'<input type="text" name="home" class="form-control" id="house'+x+'"  placeholder="Address Line1" onblur="HomeValidate('+x+')" >'+
						'<span id="HouseError'+x+'" class="text-danger font-weight-bold"></span>'+
					'</div>'+						
					'<div class="form-group">'+
						'<input type="text" name="street" class="form-control" id="landmark'+x+'"   placeholder="Address Line2" onblur="StreetValidate('+x+')" >'+
						'<span id="Landmark2Error'+x+'" class="text-danger font-weight-bold"></span>'+
					'</div>'+
					'<div class="row">'+
						'<div class="col-md-6">'+
							'<input type="text" name="city" class="form-control" id="City'+x+'"   placeholder="City" onblur="CityValidate('+x+')">'+
							'<span id="CityError'+x+'" class="text-danger font-weight-bold"></span>'+
						'</div>'+
						'<div class="col-md-6">'+
							'<input type="text" name="state" class="form-control" id="State'+x+'"   placeholder="State" onblur="StateValidate('+x+')">'+
							'<span id="StateError'+x+'" class="text-danger font-weight-bold"></span>'+
						'</div>'+
					'</div>'+
					'<br>'+
					'<div class="row">'+
						'<div class="col-md-6">'+
							'<input type="text" name="country" class="form-control" id="Country'+x+'"   placeholder="Country" onblur="CountryValidate('+x+')">'+
							'<span id="CountryError'+x+'" class="text-danger font-weight-bold"></span>'+
						'</div>'+
						'<div class="col-md-6">'+
							'<input type="text" name="zipcode" class="form-control" id="ZipCode'+x+'"   placeholder="ZipCode" onblur="ZipCodeValidate('+x+')">'+
							'<span id="ZipCodeError'+x+'" class="text-danger font-weight-bold"></span>'+
						'</div>'+
					'</div>'+
					'<input type="hidden" name="addressId" value="newAdd" />'+
				'</div>'
			);
			
	});
	
	$(wrapper).on("click","[id^=addAddress]", function(e){ //on add input button click
		
			e.preventDefault();
			
			x++; //text box increment

			y++; //new address count
			
			//add input box
			$(wrapper).append(
					
					'<br>'+
					'<div class="form-group">'+
						'<label>Address '+x+':</label>'+
						'<span style="float: right;" id="addAddress"><i class="fa fa-plus"></i></span>'+
						'<pre style="float: right;"> | </pre>'+
						'<span style="float: right;" id="removeAddress"><i class="fa fa-minus"></i></span>'+
						'<input type="text" name="home" class="form-control" id="house'+x+'"  placeholder="Address Line1" onblur="HomeValidate('+x+')" >'+
						'<span id="HouseError'+x+'" class="text-danger font-weight-bold"></span>'+
					'</div>'+						
					'<div class="form-group">'+
						'<input type="text" name="street" class="form-control" id="landmark'+x+'"   placeholder="Address Line2" onblur="StreetValidate('+x+')" >'+
						'<span id="Landmark2Error'+x+'" class="text-danger font-weight-bold"></span>'+
					'</div>'+
					'<div class="row">'+
						'<div class="col-md-6">'+
							'<input type="text" name="city" class="form-control" id="City'+x+'"   placeholder="City" onblur="CityValidate('+x+')">'+
							'<span id="CityError'+x+'" class="text-danger font-weight-bold"></span>'+
						'</div>'+
						'<div class="col-md-6">'+
							'<input type="text" name="state" class="form-control" id="State'+x+'"   placeholder="State" onblur="StateValidate('+x+')">'+
							'<span id="StateError'+x+'" class="text-danger font-weight-bold"></span>'+
						'</div>'+
					'</div>'+
					'<br>'+
					'<div class="row">'+
						'<div class="col-md-6">'+
							'<input type="text" name="country" class="form-control" id="Country'+x+'"   placeholder="Country" onblur="CountryValidate('+x+')">'+
							'<span id="CountryError'+x+'" class="text-danger font-weight-bold"></span>'+
						'</div>'+
						'<div class="col-md-6">'+
							'<input type="text" name="zipcode" class="form-control" id="ZipCode'+x+'"   placeholder="ZipCode" onblur="ZipCodeValidate('+x+')">'+
							'<span id="ZipCodeError'+x+'" class="text-danger font-weight-bold"></span>'+
						'</div>'+
					'</div>'+
					'<input type="hidden" name="addressId" value="newAdd" />'+
				'</div>'
			);
	});
	
	$("[id^=removeAddress]").click(function(e){ //user click on remove text
		
		//confirm user
		var result = confirm("Are you sure to delete?");
			
			if (y > 1) {
				if (result) {
					e.preventDefault(); 
					$(this).parent().parent('div').remove(); 
					y--;
				}
			}
			else {
				alert("one Address Reqoired");
			}
	})
	
	$(wrapper).on("click","[id^=removeAddress]", function(e){ //user click on remove text

		//confirm user
		var result = confirm("Are you sure to delete?");
			
			if (y > 1) {
				if (result) {
					e.preventDefault(); 
					$(this).parent().parent('div').remove(); 
					y--;
				}
			}
			else {
				alert("one Address Reqoired");
			}
		
	})
});