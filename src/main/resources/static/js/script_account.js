let hiddenPass = document.getElementById("hiddenpass");
let currentPassword = document.getElementById("current-password");
let newPassword = document.getElementById("new-password");
let confirmPassword = document.getElementById("confirm-password");

$(document).ready(function(){
	$("#current-password").keyup(function(){
		if(hiddenpass.value != currentPassword.value){
		
			$("#submit").attr("type", "button");
		}
		else{
			$("#submit").attr("type", "submit");
		}
	});
	
	$("#submit").click(function(){
		
			if(newPassword.value == confirmPassword.value && hiddenpass.value == currentPassword.value){

				$("#submit").attr("type", "submit");
			}
			else{

				$("#submit").attr("type", "button");
			}
		
	});
});