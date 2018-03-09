package com.bank.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bank.domain.UserInfo;
import com.bank.service.UserFacade;
import com.bank.service.impl.UserFacadeImpl;


public class LoginAction {

	private String userNO;

	private String password;

	private UserFacade userFacade;

	public LoginAction() {
		userFacade = new UserFacadeImpl();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}

	public String login() {
		int flag;
		UserInfo user = new UserInfo();
		user.setUserNO(getUserNO());
		user.setPassword(getPassword());
		try {
			flag = userFacade.login(user);
			// flag==0说明从数据库中查询出了与页面获得的帐号密码相匹配的结果
			if (flag == 0) {
				UserInfo userInfo = userFacade.selectUser(userNO);
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				// 将登录用户信息存入session
				session.setAttribute("user", userInfo);
				return "loginSuccess";
			} else if(flag == 1){
				//flag==0说明未查询到匹配的帐号密码
				return "loginError";
			}else{
				return "haveWithdraw";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// 销毁session
		session.invalidate();
		return "logout";
	}
}

