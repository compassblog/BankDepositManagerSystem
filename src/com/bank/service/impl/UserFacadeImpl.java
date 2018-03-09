package com.bank.service.impl;

import java.sql.SQLException;

import com.bank.domain.UserInfo;
import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDAOImpl;
import com.bank.service.UserFacade;


public class UserFacadeImpl implements UserFacade {

	private UserDao userDAO;
	
	public UserFacadeImpl() {
		userDAO = new UserDAOImpl();
	}

	public void deleteUserInfo(String userNO) throws SQLException {
		userDAO.deleteUserInfo(userNO);
	}

	public int login(UserInfo user) throws SQLException {
		return userDAO.login(user);
	}

	public void registService(UserInfo user) throws SQLException {
		userDAO.registService(user);
	}

	public UserInfo selectUser(String userNO) throws SQLException {
		return userDAO.selectUser(userNO);
	}

	public void updateUserInfo(UserInfo user, String userNO)
			throws SQLException {
		userDAO.updateUserInfo(user, userNO);
	}

	public void withdrawUser(String userNO) {
		userDAO.withdrawUser(userNO);
		
	}

}

