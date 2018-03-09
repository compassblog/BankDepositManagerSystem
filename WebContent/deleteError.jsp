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
		<div align="center">
			<br>
			<br>
			<br>
			<br>
			<br>
				<strong>您的帐户还有<s:property value="balance"/>元，请将剩余金额全部取出才能注销！！！</strong>
			<br><br>
            <a href="fetch.jsp">进入取款页面</a>
        </div>
	</body>
</html>
