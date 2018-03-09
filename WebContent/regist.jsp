<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>银行储蓄管理系统-注册</title>
		<style>
		 	body{
		 		margin:0;
		 		padding:0;
		 		background:url(image/background.jpg);
			}
			tr{
		    	display:block; /*将tr设置为块体元素*/
		    	margin:5px 0;  /*设置tr间距为10px*/
			}
			#top{
				margin-left:90px;
				margin-right:20px;
			}
			#bottom{
				margin-left:20px;
			}
    	</style>
    	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
    	<!--
    	<script type="text/javascript">
	    	$(function(){
	    		$("#myform").validate({
	    			rules:{
	    				"userInfo.userName":{
	    					"required":true
	    				},
	    				"userInfo.password":{
	    					"required":true,
	    					"rangelength":[6,12]
	    				},
	    				"userInfo.userAge":{
	    					"required":true,
	    					"rangelength":[2]
	    				},
	    				"userInfo.idCard":{
	    					"required":true,
	    					"rangelength":[21]
	    				},
	    				"userInfo.userSex":{
	    					"required":true
	    				},
	    				"userInfo.tel":{
	    					"required":true,
	    					"rangelength":[11]
	    				},
	    				"userInfo.city":{
	    					"required":true
	    				},
	    				"userInfo.address":{
	    					"required":true
	    				}
	    			},
	    			messages:{
	    				"userInfo.userName":{
	    					"required":"姓名不能为空"
	    				},
	    				"userInfo.password":{
	    					"required":"密码不能为空",
	    					"rangelength":"密码长度6-12位"
	    				},
	    				"userInfo.userAge":{
	    					"required":"年龄不能为空",
	    					"rangelength":"年龄只能是2位数"
	    				},
	    				"userInfo.idCard":{
	    					"required":"身份证号码不能为空",
	    					"rangelength":"请输入21位数字的身份证号码"
	    				},
	    				"userInfo.userSex":{
	    					"required":"您必须选一个性别"
	    				},
	    				"userInfo.tel":{
	    					"required":"电话号码不能为空",
	    					"rangelength":"请输入11位数字的电话号码"
	    				},
	    				"userInfo.city":{
	    					"required":"所属城市不能为空"
	    				},
	    				"userInfo.address":{
	    					"required":"地址不能为空"
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
		<br>
		<div align="center">
			 <form id="myform" action="${pageContext.request.contextPath}/regist" method="post">
			 	<table>
			 		<tr>	
				 		<td>&nbsp;&nbsp;&nbsp;姓名：&nbsp;<input type="text" name="userInfo.userName"></td>
				 	</tr>
				 	<tr>
				 		<td>&nbsp;&nbsp;&nbsp;密码：&nbsp;<input type="password" name="userInfo.password"></td>
				 	</tr>
					<tr>
				 		<td>&nbsp;&nbsp;&nbsp;年龄：&nbsp;<input type="text" name="userInfo.userAge"></td>
				 	</tr>
				 	<tr>
				 		<td>身份证：&nbsp;<input type="text" name="userInfo.idCard"></td>
				 	</tr>
				 	<tr>
				 		<td>&nbsp;&nbsp;&nbsp;性别：&nbsp;<input type="text" name="userInfo.userSex"></td>
				 	</tr>
				 	<tr>
				 		<td>&nbsp;&nbsp;&nbsp;电话：&nbsp;<input type="text" name="userInfo.tel"></td>
				 	</tr>
				 	<tr>
				 		<td>&nbsp;&nbsp;&nbsp;城市：&nbsp;<input type="text" name="userInfo.city"></td>
				 	</tr>
				 	<tr>
				 		<td>&nbsp;&nbsp;&nbsp;地址：&nbsp;<input type="text" name="userInfo.address"></td>
				 	</tr>
				 	<tr>
				 		<td><input type="submit" value="注册" id="top"></td>
				 		<td><input type="reset" value="重置" id="bottom"></td>
				 	</tr>
				 </table>
			 </form>
			 <a href="login.jsp">已有帐号？返回登录</a>
		</div>
	</body>
</html>
