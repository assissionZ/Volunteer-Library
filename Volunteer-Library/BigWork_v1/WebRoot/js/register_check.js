
function check_phone(){
	var phone = document.registerForm.phone.value;
	//var xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	var url = "RegisterCheckPhoneServlet?phone="+phone;
	xmlHttp.open("GET", url, true);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4){
			check_phone_result.innerHTML = xmlHttp.responseText;
		}
		else{
			check_phone_result.innerHTML = "正在检测...";
		}
	}
	xmlHttp.send();
}
function check_id(){
	var user_id = document.registerForm.user_id.value;
	//var xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	var url = "RegisterCheckIdServlet?user_id="+user_id;
	xmlHttp.open("GET", url, true);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4){
			check_id_result.innerHTML = xmlHttp.responseText;
		}
		else{
			check_id_result.innerHTML = "正在检测...";
		}
	}
	xmlHttp.send();
}
function check_password(){
	var password = document.registerForm.password.value;
	var password_again = document.registerForm.password_again.value;
	//var xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	var url = "RegisterCheckPasswordServlet?password="+password+"&password_again="+password_again;
	xmlHttp.open("GET", url, true);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4){
			check_password_result.innerHTML = xmlHttp.responseText;
		}
		else{
			check_password_result.innerHTML = "正在检测...";
		}
	}
	xmlHttp.send();
}
function check_address(){
	var address = document.registerForm.address.value;
	//var xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	var url = "RegisterCheckAddressServlet?address="+address;
	xmlHttp.open("GET", url, true);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4){
			check_address_result.innerHTML = xmlHttp.responseText;
		}
		else{
			check_address_result.innerHTML = "正在检测...";
		}
	}
	xmlHttp.send();
}
function check_email(){
	var email = document.registerForm.email.value;
	//var xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	var url = "MessageBoardCheckEmail?email="+email;
	xmlHttp.open("GET", url, true);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4){
			check_email_result.innerHTML = xmlHttp.responseText;
		}
		else{
			check_phone_result.innerHTML = "正在检测...";
		}
	}
	xmlHttp.send();
}