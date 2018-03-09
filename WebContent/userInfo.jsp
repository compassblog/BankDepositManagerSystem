<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<style type="text/css">
			body {
				margin:0;
				padding:0;
				background:url(image/background.jpg);
			}
		</style>
	</head>
	<body>
		<div align="center"> 
			<br>
			<br>
			<br>
			<br>
			<table border="1">
				<tr>
					<td>
						用户帐号
					</td>
					<td>
						<s:property value="userInfo.userNO" />
					</td>
				</tr>
				<tr>
					<td>
						帐户余额
					</td>
					<td>
						<s:property value="userInfo.balance" />
					</td>
				</tr>
				<tr>
					<td>
						用户姓名
					</td>
					<td>
						<s:property value="userInfo.userName" />
					</td>
				</tr>
				<tr>
					<td>
						用户性别
					</td>
					<td>
						<s:property value="userInfo.userSex" />
					</td>
				</tr>
				<tr>
					<td>
						用户年龄
					</td>
					<td>
						<s:property value="userInfo.userAge" />
					</td>
				</tr>
				<tr>
					<td>
						身份证
					</td>
					<td>
						<s:property value="userInfo.idCard" />
					</td>
				</tr>
				<tr>
					<td>
						联系电话
					</td>
					<td>
						<s:property value="userInfo.tel" />
					</td>
				</tr>
				<tr>
					<td>
						城市
					</td>
					<td>
						<s:property value="userInfo.city" />
					</td>
				</tr>
				<tr>
					<td>
						详细地址
					</td>
					<td>
						<s:property value="userInfo.address" />
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
