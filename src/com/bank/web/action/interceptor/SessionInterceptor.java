package com.bank.web.action.interceptor;

import java.util.Map;


import com.bank.domain.UserInfo;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class SessionInterceptor extends AbstractInterceptor {

	private static final Object LOGIN_KEY = "user";

	public static final String LOGIN_PAGE = "loginPage";

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map session = actionInvocation.getInvocationContext().getSession();
		UserInfo userInfo = (UserInfo) session.get(LOGIN_KEY);
		// 如果session中有userInfo对象说明是已登录用户
		if (userInfo != null) {
			return actionInvocation.invoke();
		} else {
			return LOGIN_PAGE;
		}
	}
}
