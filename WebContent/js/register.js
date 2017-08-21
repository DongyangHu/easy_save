$(document).ready(function() {
	$("#registerbt").hover(function() {
		$(this).animate({ opacity: '0.7' }, 10);
	}, function() {
		$(this).animate({ opacity: '0.8' });
	});

	var userp = document.getElementById("userp");
	var pwp = document.getElementById("pwp");
	var username = document.getElementById("username");
	var userpw1 = document.getElementById("password1");
	var userpw2 = document.getElementById("password2");

	//账户输入框判断
	//账户输入框获取焦点时
	$("#username").focus(function() {
		userp.innerHTML = "4-10个字母或数字,需以字母开头";
	});

	$("#username").blur(function() {
		//用户名过短
		if(username.value.trim().length < 4) {
			username.focus();
			userp.innerHTML = "用户名过短!";

		}
		//用户名为空
		else if(username.value.trim() == "") {
			username.focus();
			userp.innerHTML = "用户名不能为空!";

		}
		//用户名过长
		else if(username.value.trim().length > 10) {
			username.focus();
			userp.innerHTML = "用户名过长!";
		}
		//输入正确
		else {
			userp.innerHTML = "用户名可用";
			$("userp").css("color", "gray");
		}
	});

	//二次密码框失去焦点
	$("#password2").blur(function() {
		if(userpw1.value.trim() == userpw2.value.trim()) {
			pwp.innerHTML = "密码输入正确!"
		} else if(userpw1.value.trim() == "" || userpw2.value.trim() == "") {
			userpw1.focus();
			pwp.innerHTML = "密码不能为空!"
		} else {
			userpw1.value = "";
			userpw2.value = "";
			userpw1.focus();
			pwp.innerHTML = "密码不一致,请重新输入!"
		}
	});

});