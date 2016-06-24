<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts 实现文件的上传</title>
</head>
<body>
	<s:form>
		<s:textfield name="title" label="文件标题"></s:textfield>
		<s:file name="file" label="选择文件"></s:file>
		<s:submit value="上传"></s:submit>
	</s:form>
</body>
</html>