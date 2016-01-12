function validatePassword() {
	if($('#passwordsignup').val() != $('#passwordsignup_confirm').val()) {
		//document.getElementById("passwordMessage").innerHTML = "PASSWORD DOES NOT MACHT!";
		$("#passwordMessage").html("password does not match!");
		return false;
	}
	return true;
}