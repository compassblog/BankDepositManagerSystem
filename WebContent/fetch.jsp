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
				margin-left:170px;
				margin-right:15px;
			}
			#bottom{
				margin-left:15px;
			}
		</style>
	</head>
<%@include file="check.jsp"%>
	<body>
		<div align="center">
			<br><br><br>
			 <form action="fetchMoney" method="post">
			 	<table>
			 		<tr>
				 		<td><strong><font size="4">请输入取款金额：</font></strong><input type="text" name="money"></td>
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