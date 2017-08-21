<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("ID")==null) {
	response.sendRedirect("index.jsp");
}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="js/jquery-3.2.0.min.js" type="text/javascript" charset="utf-8"></script>
		
		<title>添加账号</title>
		<script>
			$(document).ready(function() {
				$("#insertbt").click(function() {
					document.forminsert.action = "${pageContext.request.contextPath}/InsertRecordServlet";
					forminsert.submit();
				});
			});
		</script>
	</head>

	<body>
		<form action="" name="forminsert" method="post">
			<table border="1">
				<tr>
					<th>账号</th>
					<th>密码</th>
					<th>账号类型</th>
				</tr>
				<tr>
					<td><input type="text" id="account" name="account" value="" /></td>
					<td><input type="text" id="password" name="password" value="" /></td>
					<td><input type="text" id="type" name="type" value="" /></td>
				</tr>
			</table>
			<input type="button" id="insertbt" name="insertbt" value="添加" />
		</form>
	</body>

</html>