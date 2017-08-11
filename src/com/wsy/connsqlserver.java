package com.wsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class connsqlserver {

	/** 
	 *   @param   args 
	 */
	private static Connection cn = null;

	public static Connection getCn() {
		return cn;
	}

	public static void setCn(Connection cn) {
		connsqlserver.cn = cn;
	}

	public Connection getConnection() {
		if (cn != null) {
			return cn;
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/daneta";
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "34814827");
			//System.out.println("Connected!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.cn = connection;
		return connection;
	}

	public ResultSet executeQuery(String sql) {
		if (cn == null)
			getConnection();
		try {
			return cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public int executeUpdate(String sql) {
		if (cn == null)
			getConnection();
		try {
			return cn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
		}
	}

	public void close() {
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cn = null;
		}
	}
}
