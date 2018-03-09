package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bank.dao.TradeDAO;
import com.bank.domain.TradeInfo;
import com.bank.utils.DBConnection;


public class TradeDAOImpl implements TradeDAO {

	Connection conn = null;
	Statement st = null;
	PreparedStatement psmt1 = null;
	ResultSet rs = null;

	// 取款业务
	public void fetchMoney(TradeInfo tradeInfo) throws SQLException {
		int sum = tradeInfo.getBalance() - tradeInfo.getMoney();
		tradeInfo.setTrade("取款");
		String sql = "update userInfo set balance = '" + sum
				+ "' where userNO = '" + tradeInfo.getUserNO() + "'";
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		String sql1 = "insert into trader(userNO,money,trade,balance,datatime) "
			+ "values('"
			+ tradeInfo.getUserNO()
			+ "','"
			+ tradeInfo.getMoney()
			+ "','"
			+ tradeInfo.getTrade()
			+ "','"
			+ sum
			+ "'," + "'" + dateString + "')";
		try {
			conn = DBConnection.getDBC();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
			st.close();
			conn.close();
		}
	}

	// 存款业务
	public void saveMoney(TradeInfo tradeInfo) throws SQLException {
		int sum = tradeInfo.getMoney() + tradeInfo.getBalance();
		tradeInfo.setTrade("存款");
		String sql = "update userInfo set balance = '" + sum
				+ "' where userNO = '" + tradeInfo.getUserNO() + "'";
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		String sql1 = "insert into trader(userNO,money,trade,balance,datatime) "
				+ "values('"
				+ tradeInfo.getUserNO()
				+ "','"
				+ tradeInfo.getMoney()
				+ "','"
				+ tradeInfo.getTrade()
				+ "','"
				+ sum
				+ "'," + "'" + dateString + "')";
		try {
			conn = DBConnection.getDBC();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
			st.close();
			conn.close();
		}
	}

	// 查询余额业务
	public Integer selectBalance(String userNO) throws SQLException {
		Integer balance = new Integer(-1);
		String sql = "select balance from userInfo where userNO = '" + userNO
				+ " '";
		try {
			conn = DBConnection.getDBC();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				balance = Integer.valueOf(rs.getString("balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return balance;
	}

	// 查询交易信息业务
	@SuppressWarnings("unchecked")
	public List selectTradeInfo(String userNO) throws SQLException {
		List list = new ArrayList();
		String sql = "select * from trader where userNO='" + userNO + "'";
		try {
			conn = DBConnection.getDBC();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TradeInfo tradeInfo = new TradeInfo();
				tradeInfo.setTrade(rs.getString("trade"));
				tradeInfo.setBalance(rs.getInt("balance"));
				tradeInfo.setDatatime(rs.getString("dataTime"));
				tradeInfo.setMoney(rs.getInt("money"));
				list.add(tradeInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		st.close();
		conn.close();
		return list;
	}

	public int findUserflag(String userNO) throws SQLException {
		String sql = "select userflag from userinfo where userNO='" + userNO + "'";
		int userflag = 0;
		try {
			conn = DBConnection.getDBC();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				userflag = rs.getInt("userflag");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		st.close();
		conn.close();
		return userflag;
	}

	//转账业务
	public boolean confirmTransfer(TradeInfo tradeInfo1, TradeInfo tradeInfo)
			throws SQLException {
		
		//更新对方帐号数据库记录
		int sum1 = tradeInfo1.getMoney() + tradeInfo1.getBalance();
		tradeInfo1.setTrade("入账");
		String sql1 = "update userInfo set balance = '" + sum1
				+ "' where userNO = '" + tradeInfo1.getUserNO() + "'";
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		String sql = "insert into trader(userNO,money,trade,balance,datatime) "
				+ "values('"
				+ tradeInfo1.getUserNO()
				+ "','"
				+ tradeInfo1.getMoney()
				+ "','"
				+ tradeInfo1.getTrade()
				+ "','"
				+ sum1
				+ "'," + "'" + dateString + "')";
		
		//更新自己帐号数据库记录
		int sum = tradeInfo.getBalance()-tradeInfo.getMoney();
		tradeInfo.setTrade("转账");
		String sql2 = "update userInfo set balance = '" + sum
				+ "' where userNO = '" + tradeInfo.getUserNO() + "'";
		Date date2 = Calendar.getInstance().getTime();
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString2 = formatter2.format(date2);
		String sql22 = "insert into trader(userNO,money,trade,balance,datatime) "
				+ "values('"
				+ tradeInfo.getUserNO()
				+ "','"
				+ tradeInfo.getMoney()
				+ "','"
				+ tradeInfo.getTrade()
				+ "','"
				+ sum
				+ "'," + "'" + dateString2 + "')";
		
		try {
			conn = DBConnection.getDBC();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.executeUpdate(sql22);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
			st.close();
			conn.close();
		}
		return true;
	}
}
