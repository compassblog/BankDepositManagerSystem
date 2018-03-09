<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>转账金额</title>
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
					margin-left:157px;
					margin-right:15px;
				}
				#bottom{
					margin-left:15px;
				}
		</style>
	</head>
	<body>
		<div align="center">
			<br><br><br>
			 <form action="confirmTransfer" method="post">
			 	<table>
			 		<tr>
			 			<td><strong>请核实收账人信息：</strong></td>
			 		</tr>
			 		<tr>
			 			<td>收账人帐号：<s:property value="account" /></td>
			 		</tr>
			 		<tr>
			 			<td>收账人名称：<s:property value="username" /></td>
			 		</tr>
			 		<tr>
				 		<td><strong>请输入转账金额：</strong><input type="text" name="money"></td>
				 	</tr>
				 	<tr>
				 		<td><input type="submit" value="确定" id="top"></td>
				 		<td><input type="reset" value="重置" id="bottom"></td>
				 	</tr>
			 	</table>
			 </form>
		</div>
	</body>
</html>