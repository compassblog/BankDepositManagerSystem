<%@ page contentType="text/html; charset=GBK" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><%request.setCharacterEncoding("GBK");%>
<html>
<head>
	<title>银行储蓄管理系统</title>
	<style type="text/css">
		body{
			background:url(image/background.jpg);
		}
		.turn{
			margin-bottom:30px;
		}
	</style>
</head>
<%@include file="check.jsp"%>
<body>
<p>&nbsp;</p>
<p class="turn">&nbsp;<a href="selectUser.action" target="mainFrame" ><img src="image/singleInfo.PNG" width="158" height="43" border="1"></a></p>
<p class="turn">&nbsp;<a href="updateUser.jsp"  target="mainFrame"><img src="image/modifyInfo.PNG" width="158" height="43" border="1"></a></p>
<p class="turn">&nbsp;<a href="logout.action" target="_parent"><img src="image/leave.PNG" width="158" height="43" border="1"></a></p>
<p class="turn">&nbsp;<a href="deleteUserInfo.jsp" target="mainFrame"><img src="image/destroy.PNG" width="158" height="43" border="1"></a></p>
<p class="turn">&nbsp;<a href="withdraw.jsp" target="mainFrame"><img src="image/lost.PNG" width="158" height="43" border="1"></a></p>
</body>
</html>
