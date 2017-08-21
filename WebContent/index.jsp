<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="img/123.ico" type="image/x-icon" />
		<script src="js/jquery-3.2.0.min.js" type="text/javascript" charset="UTF-8"></script>
		<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/header.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<title>用户登录</title>
		
		<script type="text/javascript">
			$(document).ready(function(){
				$("#loginbt").click(function(){
					document.login.action = "${pageContext.request.contextPath}/LoginServlet";
					login.submit();
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
					<form action="" method="post" name="login">
						<div id="main">
							<table border="0">
								<tr>
									<td style="font-size: 12px; color: red;">${LoginInfo}</td>
								</tr>
								<tr>
									<td><input type="text" name="userid" id="userid" value="" placeholder="用户名" style="width: 210px; height: 20px; margin-top: 10px; margin-bottom: 10px;" /></td>
								</tr>
								<tr>
									<td><input type="password" name="password" id="password" value="" placeholder="密码" style="width: 210px; height: 20px;" /></td>
								</tr>
								<tr>
									<td><input type="button" name="loginbt" id="loginbt" value="登&nbsp;&nbsp录" style="width: 210px; height: 30px; color: white; font-size: 16px; background-color: purple; opacity: 0.8; margin-top: 10px; margin-bottom: 6px; cursor: pointer;" /></td>
								</tr>
								<tr>
									<td>
										<span>
										<a href="">忘记密码?&nbsp;&nbsp;</a>|&nbsp;&nbsp;<a href="register.jsp">注册新账号</a>
										</span>
									</td>
								</tr>
							</table>
						</div>
					</form>
					<img src="img/content.jpg" style="opacity: 0.4; width: 100%; height: 100%;" />
				</div>
			</div>
			<!--页尾-->
			<div id="footer">
				<div align="center" style="padding: 5px; font-size: 12px; height: 10px;">Contact Me:
					<a href="mailto:hdyang6@yeah.net">hdyang66@yeah.net</a>
				</div>
				<div align="center" style="padding: 5px; font-size: 12px; height: 10px;">(c) Copyright 2017 HuDongyang. All Rights Reserved. 2017-3-25</div>
			</div>
		</div>
	</body>

</html>