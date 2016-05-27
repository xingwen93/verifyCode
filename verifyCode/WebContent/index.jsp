<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码</title>
<script type="text/javascript">
	function changeImg(){
		document.getElementById("validateCodeImg").src="<%=path%>/image?action=createImage&a="+Math.random();
	}
</script>
</head>
<body>
	<span><%=basePath %></span>
	<div>
		验证码:<input type="text" name="checkcode"/>
		<img id="validateCodeImg" alt="验证码" src="<%=path%>/image?action=createImage">
		<a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
	</div>
</body>
</html>