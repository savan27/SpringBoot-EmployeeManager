function validation(id) {
	
	var count = id;
	
	//to mang address error
	var err = true;

			// Validating User Information
			var fname = document.getElementById('firstName'+count).value;
			var lname = document.getElementById('lastName'+count).value;
			var password = document.getElementById('password'+count).value;
			var cpassword = document.getElementById('confirmPassword'+count).value;
			var email = document.getElementById('Email'+count).value;
			var contact = document.getElementById('Contact'+count).value;
			
			if (fname == "") 
			{
				document.getElementById('FnameError'+count).innerHTML = "* Required Field!!!";
			    return false;
			}
			if (fname != "") 
			{
				document.getElementById('FnameError'+count).innerHTML = "";
			}
			if (lname == "") 
			{
				document.getElementById('LnameError'+count).innerHTML = "* Required Field!!!";
				return false;
			}
			if (lname != "") 
			{
				document.getElementById('LnameError'+count).innerHTML = "";
			}
			if (password == "") 
			{
				document.getElementById('PasswordError'+count).innerHTML = "* Required Field!!!";
				return false;
			}
			if (password != "") 
			{
				document.getElementById('PasswordError'+count).innerHTML = "";
			}
			if (cpassword == "") 
			{
				document.getElementById('CpasswordError'+count).innerHTML = "* Required Field!!!";
				return false;
			}
			if (cpassword != "") 
			{
				document.getElementById('CpasswordError'+count).innerHTML = "";
			}
			if (email == "") 
			{
				document.getElementById('EmailError'+count).innerHTML = "* Required Field!!!";
				return false;
			}
			if (email != "") 
			{
				document.getElementById('EmailError'+count).innerHTML = "";
			}
			if (contact == "") 
			{
				document.getElementById('ContactError'+count).innerHTML = "* Required Field!!!";
				return false;
			}
			if (contact != "") 
			{
				document.getElementById('ContactError'+count).innerHTML = "";
			}
			
		
		//home field validation check if empty
		$('input[name ="home"]').each(function() {
			
			var house = $(this).val();
			if (house == "") 
			{
				document.getElementById('errMassage').innerHTML = "* All Address Field Are Required!!!";
				return err = false;
			}
			if (house != "") 
			{
				document.getElementById('errMassage').innerHTML = "";
			}
		});
		
		//landmark field validation check if empty 
		$('input[name ="leandmark"]').each(function() {
			
			var leandmark = $(this).val();
			if (leandmark == "") 
			{
				document.getElementById('errMassage').innerHTML = "* All Address Field Are Required!!!";
				return err = false;
			}
			if (leandmark != "") 
			{
				document.getElementById('errMassage').innerHTML = "";
			}
		});
		
		//City field validation check if empty 
		$('input[name ="City"]').each(function() {
			
			var City = $(this).val();
			if (City == "") 
			{
				document.getElementById('errMassage').innerHTML = "* All Address Field Are Required!!!";
				return err = false;
			}
			if (City != "") 
			{
				document.getElementById('errMassage').innerHTML = "";
			}
		});
		
		//State field validation check if empty 
		$('input[name ="State"]').each(function() {
			
			var State = $(this).val();
			if (State == "") 
			{
				document.getElementById('errMassage').innerHTML = "* All Address Field Are Required!!!";
				return err = false;
			}
			if (State != "") 
			{
				document.getElementById('errMassage').innerHTML = "";
			}
		});
		
		//Country field validation check if empty
		$('input[name ="Country"]').each(function() {
			
			var Country = $(this).val();
			if (Country == "") 
			{
				document.getElementById('errMassage').innerHTML = "* All Address Field Are Required!!!";
				return err = false;
			}
			if (Country != "") 
			{
				document.getElementById('errMassage').innerHTML = "";
			}
		});
		
		//ZipCode field validation check if empty 
		$('input[name ="ZipCode"]').each(function() {
			
			var ZipCode = $(this).val();
			if (ZipCode == "") 
			{
				document.getElementById('errMassage').innerHTML = "* All Address Field Are Required!!!";
				return err = false;
			}
			if (ZipCode != "") 
			{
				document.getElementById('errMassage').innerHTML = "";
			}
		});
		
		//address is empty
		return err;
		
}

function Addressvalidate(id) {
	
	var house = document.getElementById('house'+id).value;
	var landmark = document.getElementById('landmark'+id).value;
	var City = document.getElementById('City'+id).value;
	var State = document.getElementById('State'+id).value;
	var Country = document.getElementById('Country'+id).value;
	var ZipCode = document.getElementById('ZipCode'+id).value;
	
	
	
	if (house == "") 
	{
		document.getElementById('HouseError'+id).innerHTML = "* Required Field!!!";
		return false;
	}
	if (house != "") 
	{
		document.getElementById('HouseError'+id).innerHTML = "";
	}
	if (landmark == "") 
	{
		document.getElementById('Landmark2Error'+id).innerHTML = "* Required Field!!!";
		return false;
	}
	if (landmark != "") 
	{
		document.getElementById('Landmark2Error'+id).innerHTML = "";
	}
	if (City == "") 
	{
		document.getElementById('CityError'+id).innerHTML = "* Required Field!!!";
		return false;
	}
	if (City != "") 
	{
		document.getElementById('CityError'+id).innerHTML = "";
	}
	if (State == "") 
	{
		document.getElementById('StateError'+id).innerHTML = "* Required Field!!!";
		return false;
	}
	if (State != "") 
	{
		document.getElementById('StateError'+id).innerHTML = "";
	}
	if (Country == "") 
	{
		document.getElementById('CountryError'+id).innerHTML = "* Required Field!!!";
		return false;
	}
	if (Country != "") 
	{
		document.getElementById('CountryError'+id).innerHTML = "";
	}
	if (State == "") 
	{
		document.getElementById('StateError'+id).innerHTML = "* Required Field!!!";
		return false;
	}
	if (State != "") 
	{
		document.getElementById('StateError'+id).innerHTML = "";
	}
	if (ZipCode == "") 
	{
		document.getElementById('ZipCodeError'+id).innerHTML = "* Required Field!!!";
		return false;
	}
	if (ZipCode != "") 
	{
		document.getElementById('ZipCodeError'+id).innerHTML = "";
	}
	
}

function FnameValidate(id) {
	var fname = document.getElementById('firstName'+id).value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if (v == "") {
		document.getElementById('FnameError'+id).innerHTML = "* Required Field !!!";
		return false;
	}
	if ((v.length <= 2) || (v.length > 20)) {
		document.getElementById('FnameError'+id).innerHTML = "* Length should be 2 to 20 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('FnameError'+id).innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById('FnameError'+id).innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById('FnameError'+id).innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('FnameError'+id).innerHTML = "";
		return false;
	}
}

function LnameValidate(id) {
	var name = document.getElementById('lastName'+id).value;

	var v = name.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if (v == "") {
		document.getElementById('LnameError'+id).innerHTML = "* Required Field !!!";
		 return false;
	}
	if ((v.length <= 2) || (v.length > 20)) {
		document.getElementById('LnameError'+id).innerHTML = "* Length should be 2 to 20 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('LnameError'+id).innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) 
	{
		document.getElementById('LnameError'+id).innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) 
	{
		document.getElementById('LnameError'+id).innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('LnameError'+id).innerHTML = "";
		return false;
	}
}

function pwdValidate(id) {
	var name = document.getElementById('password'+id).value;

	var v = name.trim();

	var capital = true;
	var small = true;
	var number = true;
	var specialcaseLetter = true;

    for (var i = 0; i < v.length; i++) 
    {
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = false;

      if(charCode > 64 && charCode < 91)
        capital = false;

      if(charCode > 96 && charCode < 123)
        small = false;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = false;
	}
	if(v =="")
	{
		document.getElementById("PasswordError"+id).innerHTML="* Required Field !!!";
		return false;
	}
	else if((v.length <8) || (v.length >= 12))
	{
		document.getElementById('PasswordError'+id).innerHTML="**Please enter the password between 8 to 12";
		return false;
	}
	else if(capital){
		document.getElementById('PasswordError'+id).innerHTML="**Please At least 1 capital ";
		return false;
	}
	else if(small){
		document.getElementById('PasswordError'+id).innerHTML="**Please At least 1 smallcap";
		return false;
	}
	else if(number){
		document.getElementById('PasswordError'+id).innerHTML="**Please At least 1 numerical";
		return false;
	}
	else if(specialcaseLetter){
		document.getElementById('PasswordError'+id).innerHTML="**Please At least 1 specialcaseLetter";
		return false;
	}
	else
	{
		document.getElementById('PasswordError'+id).innerHTML = "";
		return false;
	}
}

function cpwdValidate(id) {
	var name1 = document.getElementById('password'+id).value;
	var name2 = document.getElementById('confirmPassword'+id).value;

	var v1 = name1.trim();
	var v2 = name2.trim();

	if (v2 == "") {
		document.getElementById('CpasswordError'+id).innerHTML = "* Required Field !!!";
		 return false;
	}
	if (v1 != v2) {
		document.getElementById('CpasswordError'+id).innerHTML = "* Password doesn't Match...!!!";
	}
	else
	{
		document.getElementById('CpasswordError'+id).innerHTML = "";
		return false;
	}
}

function emailValidate(id) {
	var name = document.getElementById('Email'+id).value;

	var v = name.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;
      
      if((charCode > 32 && charCode < 46) || (charCode > 57 && charCode < 64) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 47)
        specialcaseLetter   = true;
	}
	
	if(v =="")
	{
		document.getElementById('EmailError'+id).innerHTML="* Required Field !!!";
		return false;
	}
	var res = v.split('@');

	if(v.split('@').length != 2)
	{
		document.getElementById('EmailError'+id).innerHTML="**Please enter the valid number of @..!!!";
		return false;
	}

	var part1=res[0];
	var part2=res[1];

	 if(part1.length < 3)
	{
		document.getElementById('EmailError'+id).innerHTML="* Three character before the '@' required...!!!";
		return false;
	}
	 if(part1.split(' ').length>1)
	{
		document.getElementById('EmailError'+id).innerHTML="* Invalid : Space before @";
		return false;
	}

	var dotsplt=part2.split(".");  //alert(“After @ :”+part2);

	 if(part2.split('.').length<2)
	{
		document.getElementById('EmailError'+id).innerHTML="* '.' Missing..!!!";
		return false;
	}
	 if(dotsplt[0].length < 3 )
	{
		console.log('demo',v);
		document.getElementById('EmailError'+id).innerHTML="* Three character before the '.' required...!!!";
		return false;
	}
	 if(dotsplt[0].split(' ').length>1)
	{
		document.getElementById('EmailError'+id).innerHTML="* Invalid : Space before '.'...!!!!";
		return false;
	}
	 if(dotsplt[1].length<2 ||dotsplt[1].length>3)
	{
		document.getElementById('EmailError'+id).innerHTML="* character aftr '.' must be in between 2 to 3 ...!!!";
		return false;
	}
	if(dotsplt[1].split('specialcaseLetter')>1)
	{
		document.getElementById('EmailError'+id).innerHTML="* Number aftr '.' Not Allowed ...!!!";
		return false;
	}
	if (specialcaseLetter) 
	{
		document.getElementById('EmailError'+id).innerHTML="* Special Character Not Allowed...!!!";
		return false;
	}
	if (true)
	{
		document.getElementById('EmailError'+id).innerHTML="";
		return false;
	}
}

function conValidate(id) {

	var name = document.getElementById('Contact'+id).value;

	var v = name.trim();

	if(v =="")
	{
		document.getElementById('ContactError'+id).innerHTML="* Required Field !!!";
		return false;
	}
	else if (v[0] === '0') {
		document.getElementById('ContactError'+id).innerHTML="* First Didgit Should not be zero..!!!";
		return false;
	}
	else if(v.split(' ').length > 1)
	{
		document.getElementById('ContactError'+id).innerHTML="* Invalid : Space between Number...!!!";
		return false;
	}
	else if ((v.length < 10) ) {
		document.getElementById('ContactError'+id).innerHTML = "* Length must be 10 digits only....!!!";
		return false;
	}
	else if ((v.length > 10)) {
		document.getElementById('ContactError'+id).innerHTML = "* Length should be 10 digits only....!!!";
		return false;
	}
	else if(isNaN(v))
	{
		document.getElementById('ContactError'+id).innerHTML="**Please enter the number only";
		return false;
	}
	else
	{
		document.getElementById('ContactError'+id).innerHTML="";
		return false;
	}
}

function HomeValidate(id) {
	var name = document.getElementById(id+'.house').value;
	console.log(name)
	var v = name.trim();

	if (v == "") {
		document.getElementById(id+'.HouseError').innerHTML = "* Required Field !!!";
	}
	else if ((v.length < 4) || (v.length > 30)) {
		document.getElementById(id+'.HouseError').innerHTML = "* Length should be 5 to 30 character !!!";
		return false;
	}
	else
	{
		document.getElementById(id+'.HouseError').innerHTML = "";
		return false;
	}
	
}

function StreetValidate(id) {
	var name = document.getElementById(id+'.landmark').value;

	var v = name.trim();

	if (v == "") {
		document.getElementById(id+'.Landmark2Error').innerHTML = "* Required Field !!!";
	}
	else if ((v.length < 4) || (v.length > 30)) {
		document.getElementById(id+'.Landmark2Error').innerHTML = "* Length should be 5 to 30 character !!!";
		return false;
	}
	else
	{
		document.getElementById(id+'.Landmark2Error').innerHTML = "";
		return false;
	}
}

function CityValidate(id) {
	var fname = document.getElementById(id+'.City').value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if(v =="")
	{
		document.getElementById(id+'.CityError').innerHTML="* Required Field !!!";
		return false;
	}
	if ((v.length < 4) || (v.length >= 10)) {
		document.getElementById(id+'.CityError').innerHTML = "* Length should be 5 to 10 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById(id+'.CityError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById(id+'.CityError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById(id+'.CityError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById(id+'.CityError').innerHTML = "";
		return false;
	}
}

function StateValidate(id) {
	var fname = document.getElementById(id+'.State').value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if(v =="")
	{
		document.getElementById(id+'.StateError').innerHTML="* Required Field !!!";
		return false;
	}
	if ((v.length < 4) || (v.length >= 10)) {
		document.getElementById(id+'.StateError').innerHTML = "* Length should be 5 to 10 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById(id+'.StateError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById(id+'.StateError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById(id+'.StateError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById(id+'.StateError').innerHTML = "";
		return false;
	}
}

function CountryValidate(id) {
	var fname = document.getElementById(id+'.Country').value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if(v =="")
	{
		document.getElementById(id+'.CountryError').innerHTML="* Required Field !!!";
		return false;
	}
	if ((v.length < 4) || (v.length >= 10)) {
		document.getElementById(id+'.CountryError').innerHTML = "* Length should be 4 to 10 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById(id+'.CountryError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById(id+'.CountryError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById(id+'.CountryError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById(id+'.CountryError').innerHTML = "";
		return false;
	}
}

function ZipCodeValidate(id) {

	var name = document.getElementById(id+'.ZipCode').value;

	var v = name.trim();

	if(v =="")
	{
		document.getElementById(id+'.ZipCodeError').innerHTML="* Required Field !!!";
		return false;
	}
	else if(v.split(' ').length > 1)
	{
		document.getElementById(id+'.ZipCodeError').innerHTML="* Invalid : Space between Number...!!!";
		return false;
	}
	else if ((v.length < 6) || (v.length > 6)) {
		document.getElementById(id+'.ZipCodeError').innerHTML = "* Length should be 6 to 10 digits only....!!!";
		return false;
	}
	else if(isNaN(v))
	{
		document.getElementById(id+'.ZipCodeError').innerHTML="**Please enter the number only";
		return false;
	}
	else
	{
		document.getElementById(id+'.ZipCodeError').innerHTML="";
		return false;
	}
}
