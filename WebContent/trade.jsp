<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
	<head>
		<title>银行储蓄管理系统</title>
		<style type="text/css">
			
		</style>
	</head>
	<%@include file="check.jsp"%>
	<frameset rows="110,*" cols="*" framespacing="4" frameborder="yes" border="4" bordercolor="#000000">
	  <frame src="top.jsp" name="topFrame" >
	  <frameset rows="*" cols="198,*,198" framespacing="4" frameborder="yes" border="4" bordercolor="#000000">
	    <frame src="left.jsp" name="leftFrame" >
	    <frame src="main.jsp" name="mainFrame">
	    <frame src="right.jsp" name="rightFrame" >
	  </frameset>
	</frameset>
	<noframes>
	
	<body>
	</body>
	
	</noframes>
</html>
