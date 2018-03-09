<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>转账成功</title>
		<style type="text/css">
			body {
				margin:0;
				padding:0;
				background:url(image/background.jpg);
			}
		</style>
	</head>
	<body>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div align="center">
			<p style="font-size:30px;">
				<strong>操作成功，您的帐户余额为</strong><s:property value="balance" />元
			</p>
		</div>
	</body>
</html>