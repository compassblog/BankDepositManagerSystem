package com.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.bank.domain.TradeInfo;


public interface TradeFacade {
	/**
	 * 存款业务
	 */
	void saveMoney(TradeInfo tradeInfo) throws SQLException;

	/**
	 * 取款业务
	 */
	void fetchMoney(TradeInfo tradeInfo) throws SQLException;

	/**
	 * 查询帐户余额
	 * 
	 * @param userNO
	 *            当前登录用户帐号
	 * @return 返回帐户余额
	 */
	Integer selectBalance(String userNO) throws SQLException;

	/**
	 * 查询当前登录用户所有交易信息
	 * 
	 * @param userNO
	 *            当前登录用户帐号
	 * @return 返回交易信息
	 */
	List selectTradeInfo(String userNO) throws SQLException;

	int findUserflag(String userNO) throws SQLException;

	boolean confirmTransfer(TradeInfo tradeInfo1, TradeInfo tradeInfo) throws SQLException;
}
