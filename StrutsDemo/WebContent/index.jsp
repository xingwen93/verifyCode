<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath();
    	String basePath = request.getScheme()+":"+request.getServerPort()+"/"+request.getServerName()+path;
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<script type="text/javascript">
//获取当前网址
var curWwwPath = window.document.location.href;
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8083
var localhostPaht = curWwwPath.substring(0, pos);
//获取带"/"的项目名，如：/uimcardprj
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
console.log(projectName);
var projectAllName = localhostPaht + projectName;
</script>
<style>
	.inp{
		margin-bottom: 10px;
		margin-top: 20px;
		width: 250px;
		height: 25px;
		border-color: gray;
	}
	.btn{
		width: 50px;
		height: 30px;
		margin: 10px;
		font-weight: bold;
		color: white;
		font-size: 12px;
		text-align: center;
		font-family: Arial;
	}
	.login{
		background-color: blue; 
	}
	.register{
		background-color: green;
	}
</style>
</head>
<body>
	<h1>登录成功</h1>
</body>
</html>