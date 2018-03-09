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
			<p>修改信息成功，具体信息如下：</p>
			<table border="1">
				<tr>
					<td>
						密码：
					</td>
					<td>
						<s:property value="userInfo.password" />
					</td>
				</tr>
				<tr>
					<td>
						联系电话：
					</td>
					<td>
						<s:property value="userInfo.tel" />
					</td>
				</tr>
				<tr>
					<td>
						居住城市：
					</td>
					<td>
						<s:property value="userInfo.city" />
					</td>
				</tr>
				<tr>
					<td>
						详细地址：
					</td>
					<td>
						<s:property value="userInfo.address" />
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
