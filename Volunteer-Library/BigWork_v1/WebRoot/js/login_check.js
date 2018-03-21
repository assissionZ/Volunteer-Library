/**
 * 
 */
function askForLogin()
{
    alert("请先登录！")
}
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) 
    	return unescape(r[2]); 
    return null;
}

var login_error = getUrlParam('login_error');
//alert("login_error="+login_error);
if(login_error!=null && login_error.toString()=="1"){
	window.onload = openLoginModal();
	//document.getElementById("user_id_login").value = getCookie("user_id");
	//alert(getCookie("user_id"));
	//document.getElementById("password_login").value = getCookie("password");

}
var register_error = getUrlParam('register_error');
//alert("register_error="+register_error);
if(register_error!=null && register_error.toString()=="1"){
	window.onload = openRegisterModal();
	//document.getElementById("user_id_login").value = getCookie("user_id");
	//alert(getCookie("user_id"));
	//document.getElementById("password_login").value = getCookie("password");
		
}