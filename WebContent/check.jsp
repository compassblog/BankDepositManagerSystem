<%@ page language="java" import="com.bank.domain.UserInfo"%>
<%
	Object obj=(Object)request.getSession().getAttribute("user");
	
	if (obj == null) {
		response.sendRedirect("wrong.jsp");
	} else {
		UserInfo userInfo = (UserInfo) obj;
	}
%>
