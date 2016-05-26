<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码</title>
</head>
<body>
	<span><%=basePath %></span>
	<div>
		验证码:<input type="text" name="checkcode" />
		<img alt="验证码" src="<%=path%>/">
		<a href="javascript:reloadCode()">看不清楚</a>
	</div>
</body>
</html>