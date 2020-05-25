$(document).ready(function() {

    
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();


            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
    
    function validateImage(input){
    	//get file name
        var FileUploadPath = input;
        //get file extension
        var Extension = FileUploadPath.substring(FileUploadPath.lastIndexOf('.') + 1).toLowerCase();
    	
        if (!(Extension == "gif" || Extension == "png" || Extension == "bmp"|| Extension == "jpeg" || Extension == "jpg")) {
        	document.getElementById('FileError').innerHTML = "**Image Input Only..!!";
            return false;
        }
    }
    

    $(".file-upload").on('change', function(){
    	var a = $(this).val();
    	var b = validateImage(a);
    	if (b == false) {
    		$('.profile-pic').attr('src', "image/user-purple.png");
    		return false;
		}
    	var c = (this.files[0].size);
    	if (c > 2000000) {
            document.getElementById('FileError').innerHTML = "**File size exceeds 2 MB, Please Try Another One..!!";
            return false;
        }
		readURL(this);
    });
    
    $(".upload-button").on('click', function() {
       $(".file-upload").click();
    });
});