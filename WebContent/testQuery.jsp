<%@page import="java.sql.ResultSet"%>
<%@page import="pers.hdy.easy_save.util.BaseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.spanbt{color: #1E90FF;}
</style>


<title>显示数据</title>
</head>
<body>
<%
if(session.getAttribute("ID")==null) {
	response.sendRedirect("index.jsp");
}else{
BaseDao basedao = new BaseDao();
basedao.linkDB();
ResultSet Rs = basedao.queryData("account_data", "*", "UserID = '"+(String)session.getAttribute("ID")+"'");
%>
${InsertRecordResult }
<span>${ LoginInfo}<br>用户:<%=session.getAttribute("username") %>&nbsp;权限:<%=session.getAttribute("flag") %>.</span>
<table border="1" bordercolor="gray">
	<tr>
		<th>记录编号</th>
		<th>账&nbsp;&nbsp;&nbsp;&nbsp;号</th>
		<th>账号密码</th>
		<th>账号类型</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
<%while(Rs.next()){ %>
	<tr>
		<td><%=Rs.getString(1) %></td>
		<td><%=Rs.getString(2) %></td>
		<td><%=Rs.getString(3) %></td>
		<td><%=Rs.getString(4) %></td>
		<td><%=Rs.getString(5) %></td>
		<td><span class="spanbt">编辑</span>&nbsp;<span class="spanbt">删除</span></td>
	</tr>
<%}
basedao.closeDB();
}
%>
</table>
<a href="insert.jsp">添加</a>
</body>
</html>