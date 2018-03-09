<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
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
				margin-left:107px;
				margin-right:15px;
			}
			#bottom{
				margin-left:15px;
			}
		</style>
	</head>
	<%@include file="check.jsp"%>
	<body>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div align="center">
		 	<form action="updateUser" method="post">
		 		<table>
		 			<tr>
		 				<td>用户帐号：<s:property value="#session.user.userNO" /></td>
		 			</tr>
		 			<tr>
		 				<td>用户密码：<input type="password" name="userInfo.password"></td>
		 			</tr>
		 			<tr>
		 				<td>联系电话：<input type="text" name="userInfo.tel"></td>
		 			</tr>
		 			<tr>
		 				<td>居住城市：<input type="text" name="userInfo.city"></td>
		 			</tr>
		 			<tr>
		 				<td>详细地址：<input type="text" name="userInfo.address"></td>
		 			</tr>
		 			<tr>
		 				<td><input type="submit" value="提交" id="top"></td>
		 				<td><input type="reset" value="重置" id="bottom"></td>
		 			</tr>
		 		</table>
		 	</form>
		</div>
	</body>
</html>
