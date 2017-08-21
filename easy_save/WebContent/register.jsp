<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="img/123.ico" type="image/x-icon" />
		<script src="js/jquery-3.2.0.min.js" type="text/javascript" charset="UTF-8"></script>
		<script src="js/register.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/header.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css" />
		<link rel="stylesheet" type="text/css" href="css/register.css" />
		<title>用户注册</title>
		<script type="text/javascript">
			
			$(document).ready(function(){
				var username = document.getElementById("username");
				var userpw1 = document.getElementById("password1");
				var userpw2 = document.getElementById("password2");
				//点击注册按钮
				$("#registerbt").click(function() {
					if(username.value.trim().length < 4 ||
						username.value.trim().length > 10 ||
						userpw1.value.trim() != userpw2.value.trim() ||
						username.value.trim() == "" ||
						userpw1.value.trim() == "" ||
						userpw2.value.trim() == "") {
						alert("请输入正确的注册信息!");
						username.focus();
						username.value = "";
						userpw1.value = "";
						userpw2.value = "";
					} else {
						document.registerform.action = "${pageContext.request.contextPath}/RegisterServlet";
						registerform.submit();
					}
				});
			});
			
		</script>
	</head>

	<body>
		<!--整个页面-->
		<div id="window">
			<!--顶部-->
			<div id="top">
				<img src="img/logo.png" width="30%" height="100%" />
			</div>
			<!--中间页面内容-->
			<div id="content">
				<div id="content1">
					<form action="" method="post" name="registerform">
						<div id="main">
							<table border="0">
								<tr>
									<td>
										<p class="p1">用&nbsp;户&nbsp;名:</p>
										<input type="text" name="username" id="username" value="" placeholder="用户名" style="width: 210px; height: 20px; margin-top: 10px; float: right;" /></td>
									<td>
										<p class="help" id="userp"></p>
									</td>
								</tr>
								<tr>
								</tr>
								<tr>
									<td>
										<p class="p1">密&nbsp;&nbsp;&nbsp;&nbsp;码:</p>
										<input type="password" name="password1" id="password1" value="" placeholder="密码" style="width: 210px; height: 20px; margin-top: 10px; float: right;" /></td>
									<td>
										<p class="p1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
									</td>
								</tr>
								<tr>
									<td>
										<p class="p1">确认密码:</p>
										<input type="password" name="password2" id="password2" value="" placeholder="再次输入密码" style="width: 210px; height: 20px; margin-top: 10px; float: right;" /></td>
									<td>
										<p class="help" id="pwp"></p>
									</td>
								</tr>
								<tr>
									<td><input type="button" name="registerbt" id="registerbt" value="注&nbsp;&nbsp册" style="width: 200px; height: 36px; color: white; font-size: 16px; background-color: purple; opacity: 0.8; margin-top: 20px; margin-bottom: 6px; margin-left: 10px; cursor: pointer;" /><span><a
										href="index.jsp">返回</a></span></td>
								</tr>
							</table>
						</div>
					</form>
					<img src="img/content.jpg" style="opacity: 0.4; width: 100%; height: 100%;" />
				</div>

			</div>
			<!--页尾-->
			<div id="footer">
				<div align="center" style="padding: 5px; font-size: 12px; height: 10px;">
					Contact Me:
					<a href="mailto:hdyang6@yeah.net">hdyang66@yeah.net</a>
				</div>
				<div align="center" style="padding: 5px; font-size: 12px; height: 10px;">(c) Copyright 2017 HuDongyang. All Rights Reserved. 2017-3-25</div>
			</div>
		</div>
	</body>

</html>