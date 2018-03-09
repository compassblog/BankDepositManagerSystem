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
<p class="turn">&nbsp;<a href="save.jsp" target="mainFrame"><img src="image/cunkuan.PNG" width="158" height="43" border="1"></a></p>
<p class="turn">&nbsp;<a href="fetch.jsp" target="mainFrame"><img src="image/qukuan.PNG" width="158" height="43" border="1"></a></p>
<p class="turn">&nbsp;<a href="transfer.jsp" target="mainFrame"><img src="image/zhuanzhang.PNG" width="158" height="43" border="1"></a></p>
<p class="turn">&nbsp;<a href="selectBalance.action" target="mainFrame"><img src="image/selectBalance.PNG" width="158" height="43" border="1"></a></p>
<p class="turn">&nbsp;<a href="selectTradeInfo.action" target="mainFrame"><img src="image/transferInfo.PNG" width="158" height="43" border="1"></a></p>
</body>
</html>
