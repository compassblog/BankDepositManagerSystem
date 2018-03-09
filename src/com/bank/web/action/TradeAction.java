package com.bank.web.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bank.domain.TradeInfo;
import com.bank.domain.UserInfo;
import com.bank.service.TradeFacade;
import com.bank.service.UserFacade;
import com.bank.service.impl.TradeFacadeImpl;
import com.bank.service.impl.UserFacadeImpl;


public class TradeAction {

	private TradeFacade tradeFacade;
	
	TradeInfo tradeInfo;

	private Integer money;

	private String tradeType;

	private Integer balance;

	private List<TradeInfo> list;
	
	private String userNO;

	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}
	
	private String account;
	
	private String username;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TradeAction() {
		tradeFacade = new TradeFacadeImpl();
		tradeInfo = new TradeInfo();
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public List<TradeInfo> getList() {
		return list;
	}

	public void setList(List<TradeInfo> list) {
		this.list = list;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String fetchMoney() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user")).getUserNO());
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		String tt = getTradeType();
		Integer balance = tradeFacade.selectBalance(userNO);
		tradeInfo.setUserNO(userNO);
		tradeInfo.setTrade(tt);
		tradeInfo.setBalance(balance);
		tradeInfo.setMoney(money);
		if (userflag == 1) {
			return "abilityError";
		} else {
			// 如果取款金额大于帐户余额则提示出错
			if (tradeInfo.getMoney() > balance.intValue()) {
				return "fetchError";
			} else {
				tradeFacade.fetchMoney(tradeInfo);
				return "fetchSuccess";
			}
		}
	}

	public String saveMoney() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		// 从session中获得帐户是否注销标志userflag
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		String tt = getTradeType();
		Integer balance = tradeFacade.selectBalance(userNO);
		tradeInfo.setUserNO(userNO);
		tradeInfo.setTrade(tt);
		tradeInfo.setBalance(balance);
		tradeInfo.setMoney(money);
		// userflag==1说明帐户已经被注销
		if (userflag == 1) {
			return "abilityError";
		} else {
			tradeFacade.saveMoney(tradeInfo);
			return "saveSuccess";
		}
	}

	public String selectBalance() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if((UserInfo) session.getAttribute("user") == null){
			return "selectError";
		}
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		if (userflag == 1) {
			return "abilityError";
		} else {
			try {
				Integer balance = tradeFacade.selectBalance(userNO);
				setBalance(balance);
			} catch (SQLException e) {
				e.printStackTrace();
				return "Error";
			}
			return "selectBalance";
		}
	}

	@SuppressWarnings("unchecked")
	public String tradeInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if((UserInfo) session.getAttribute("user") == null){
			return "selectError";
		}
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		try {
			List list = tradeFacade.selectTradeInfo(userNO);
			setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error";
		}
		return "selectTradeInfo";
	}
	
	public String transferMoney() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//获取对方的帐号并存放入session域中
		UserInfo user1 = new UserInfo();
		String account = getUserNO();
		user1.setUserNO(account);
		setAccount(account);
		
		UserInfo userInfo = new UserInfo();
		UserFacade userFacade = new UserFacadeImpl();
		userInfo = userFacade.selectUser(getUserNO());
		String  username1 = (userInfo.getUserName()).substring(0, 1);
		String username = username1 + "**";
		setUsername(username);
		
		session.setAttribute("user1", user1);
		//查询对方帐号是否注销
		int userflag1 = tradeFacade.findUserflag(getUserNO());
		//对方帐号没有注销，则通过JDBC事务处理，使对方帐号余额增加转账数额，并表示为入账；注销则不能操作
	
		//查询自己帐号是否注销
		int userflag = ((UserInfo) session.getAttribute("user")).getUserflag();
		
		if (userflag == 1) {
			return "abilityError";
		} else {
			// 如果自己帐号没有注销，则可以判断对方帐号是否注销
			if(userflag1 == 1)
				return "abilityError";
			else
				return "userflagExist";
		}
	}
	
	public String confirmTransfer() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//获取对方帐号相关信息
		String userNO1 = (String) (((UserInfo) session.getAttribute("user1"))
				.getUserNO());
		String tt1 = getTradeType();
		Integer balance1 = tradeFacade.selectBalance(userNO1);
		TradeInfo tradeInfo1 = new TradeInfo();
		tradeInfo1.setUserNO(userNO1);
		tradeInfo1.setTrade(tt1);
		tradeInfo1.setBalance(balance1);
		tradeInfo1.setMoney(money);
		
		//自己帐号相关信息
		String userNO = (String) (((UserInfo) session.getAttribute("user"))
				.getUserNO());
		String tt = getTradeType();
		Integer balance2 = tradeFacade.selectBalance(userNO);
		tradeInfo.setUserNO(userNO);
		tradeInfo.setTrade(tt);
		tradeInfo.setBalance(balance2);
		tradeInfo.setMoney(money);
		
		boolean flag = tradeFacade.confirmTransfer(tradeInfo1,tradeInfo);
		
		//事务提交成功，返回true，否则返回false
		if (flag == true) {
			Integer balance = tradeFacade.selectBalance(userNO);
			setBalance(balance);
			return "transferSuccess";
		} else {
			return "transferError";
		}
	}
}
