<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
    	<title>银行储蓄管理系统-登录</title>
    	<style type="text/css">
	    	body{
	    		margin:0;
	    		padding:0;
	    		background:url(image/background.jpg);
	    	}
	    	tr{
			    display:block; /*将tr设置为块体元素*/
			    margin:10px 0;  /*设置tr间距为10px*/
			}
			#top{
				margin-left:75px;
				margin-right:15px;
			}
			#bottom{
				margin-left:15px;
			}
    	</style>
    	
    	<!-- 
    	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
    	<script type="text/javascript">
			$(function(){
				$("#myform").validate({
					rules:{
						"userNO":{
							"required":true,
							"rangelength":[13]
						},
						"password":{
							"required":true,
							"rangelength":[6,12]
						},
					},
					messages:{
						"userNO":{
							"required":"帐号不能为空",
							"rangelength":"请输入13位数字的帐号"
						},
						"password":{
							"required":"密码不能为空",
							"rangelength":"密码长度6-12位"
						}
					}
				});
			});
		</script>
		 -->
    </head>
	<body>
		<div align="center">
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		    <p style="font-size:50px;"><strong>银行储蓄管理系统</strong></p>
	    </div>
		<div align="center">
				 <form id="myform" action="${pageContext.request.contextPath}/login" method="post">
				 	<table>
				 		<tr>	
					 		<td>帐号：<input type="text" name="userNO" id="userNO"></td>
					 	</tr>
					 	<tr>
					 		<td>密码：<input type="password" name="password" id="password"></td>
					 	</tr>
					 	<tr>
					 		<td><input type="submit" value="登录" id="top"></td>
					 		<td><input type="reset" value="重置" id="bottom"></td>
					 	</tr>
				 	</table>
				 </form>
				 <a href="regist.jsp">没有帐号？前往注册</a>
		</div>
	</body>
</html>
