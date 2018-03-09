package com.bank.service;

import java.sql.SQLException;

import com.bank.domain.UserInfo;


public interface UserFacade {
	/**
	 * 登录业务
	 * 
	 * @param user
	 *            登录信息对象
	 * @return 登录成功标志
	 */
	int login(UserInfo user) throws SQLException;

	/**
	 * 注册业务
	 * 
	 * @param user
	 *            注册信息对象
	 */
	void registService(UserInfo user) throws SQLException;

	/**
	 * 查询个人帐户信息
	 * 
	 * @param userNO
	 *            当前登录用户帐号
	 * @return
	 */
	UserInfo selectUser(String userNO) throws SQLException;

	/**
	 * 修改个人帐户信息
	 * 
	 * @param user
	 * @param userNO
	 */
	void updateUserInfo(UserInfo user, String userNO) throws SQLException;

	/**
	 * 注销个人帐户
	 * 
	 * @param userNO
	 */
	void deleteUserInfo(String userNO) throws SQLException;

	void withdrawUser(String userNO);
}

