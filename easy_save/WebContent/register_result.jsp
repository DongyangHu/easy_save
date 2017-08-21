<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="img/123.ico" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/header.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css" />
		<link rel="stylesheet" type="text/css" href="css/register.css" />
		<title>用户注册</title>

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
					<form action="" method="post" name="registersuccess">
						<div id="main">
							<h3>${register_result}</h3>
						<a href="index.jsp">返回</a>
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