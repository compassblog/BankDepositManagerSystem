<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>银行储蓄管理系统-首页</title>
		<style type="text/css">
			body {
				margin:0;
				padding:0;
				background:url(image/background.jpg);
			}
		</style>
		<script> 
				var t=8;//设定跳转的时间 
				setInterval("refer()",1000); //启动1秒定时 
				function refer(){ 
					if(t==0){ 
					location="login.jsp"; //#设定跳转的链接地址 
					} 
					document.getElementById('show').innerHTML=""+t+"秒后跳转到登录界面"; // 显示倒计时 
					t--; // 计数器递减 
				} 
		</script> 
	</head>
	<body>
		<div align="center">
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p style="font-size:50px;"><strong>欢迎使用</strong></p>
			<p style="font-size:50px;"><strong>指南者银行储蓄管理系统</strong></p>
			<span id="show"></span> 
			<p style="font-size:20px;">如果没有自动跳转，请&nbsp;<a href="login.jsp">点击这里</a></p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>Copyright &copy; 2017 指南者工作室</p>
		</div>
	</body>
</html>