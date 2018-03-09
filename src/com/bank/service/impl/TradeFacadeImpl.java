package com.bank.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bank.domain.TradeInfo;
import com.bank.dao.TradeDAO;
import com.bank.dao.impl.TradeDAOImpl;
import com.bank.service.TradeFacade;


public class TradeFacadeImpl implements TradeFacade {

	private TradeDAO tradeDAO;

	public TradeFacadeImpl() {
		tradeDAO = new TradeDAOImpl();
	}

	public void fetchMoney(TradeInfo tradeInfo) throws SQLException {
		tradeDAO.fetchMoney(tradeInfo);
	}

	public void saveMoney(TradeInfo tradeInfo) throws SQLException {
		tradeDAO.saveMoney(tradeInfo);
	}

	public Integer selectBalance(String userNO) throws SQLException {
		return tradeDAO.selectBalance(userNO);
	}

	public List selectTradeInfo(String userNO) throws SQLException {
		return tradeDAO.selectTradeInfo(userNO);
	}

	public int findUserflag(String userNO) throws SQLException {
		return tradeDAO.findUserflag(userNO);
	}

	public boolean confirmTransfer(TradeInfo tradeInfo1, TradeInfo tradeInfo)
			throws SQLException {
		return tradeDAO.confirmTransfer(tradeInfo1,tradeInfo);
	}

}
