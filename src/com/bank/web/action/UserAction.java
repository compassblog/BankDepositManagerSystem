package com.bank.web.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bank.domain.UserInfo;
import com.bank.service.UserFacade;
import com.bank.service.impl.UserFacadeImpl;


public class UserAction {

	private UserFacade userFacade;

	private UserInfo userInfo;

	int balance;

	public UserAction() {
		userFacade = new UserFacadeImpl();
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String regist() {
		UserInfo user = getUserInfo();
		try {
			userFacade.registService(user);
			setUserInfo(user);
			return "registSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	public String selectUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		try {
			UserInfo user = userFacade.selectUser(userNO);
			setUserInfo(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
		return "selectUser";
	}

	public String updateUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		if (userflag == 1) {
			return "abilityError";
		} else {
			UserInfo userInfo = getUserInfo();
			try {
				userFacade.updateUserInfo(userInfo, userNO);
				setUserInfo(userInfo);
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error";
			}
			return "updateSuccess";
		}
	}

	public String deleteUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		int balance = 0;
		try {
			UserInfo userInfo = userFacade.selectUser(userNO);
			balance = userInfo.getBalance();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		// 如果帐户余额大于零，不允许注销操作，提示出错
		if (balance > 0) {
			setBalance(balance);
			return "deleteError";
		} else {
			try {
				userFacade.deleteUserInfo(userNO);
				session.setAttribute("user", userFacade.selectUser(userNO));
				return "deleteSuccess";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error";
			}
		}
	}
	
	public String withdrawUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if((UserInfo) session.getAttribute("user") == null){
			return "withdrawError";
		}
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());

		try {
			userFacade.withdrawUser(userNO);
			session.invalidate();
			return "withdrawSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
}
