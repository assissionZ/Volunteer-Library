/**
 * 
 */
function getCookie(name)
{
	var arr,reg = new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr = document.cookie.match(reg))
		return unescape(arr[2]);
	else
		return null;
}
function outputLoginCookie(){ 
	document.getElementById("user_id_login").value = getCookie("user_id");
	document.getElementById("password_login").value = getCookie("password");
};  
function outputRegisterCookie(){ 
	document.getElementById("user_id").value = getCookie("user_id");
	document.getElementById("user_name").value = getCookie("user_name");
	document.getElementById("password").value = getCookie("password");
	document.getElementById("password_again").value = getCookie("password_again");
	document.getElementById("phone").value = getCookie("phone");
	document.getElementById("address").value = getCookie("address");
};  
