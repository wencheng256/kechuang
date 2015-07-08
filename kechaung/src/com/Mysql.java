package com;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class Mysql {

	static private Mysql mysql = null;

	private Connection connection;
	private Statement statement;

	// 获得JDBC Mysql连接
	private Mysql() {
		try {
			InputStream in= getClass().getClassLoader().getResourceAsStream("mysql.properties");
			Properties prop = new Properties();
			prop.load(in);
			String host=prop.getProperty("host");
			String duan=prop.getProperty("port");
			String db=prop.getProperty("db_name");
			String username=prop.getProperty("username");
			String pass=prop.getProperty("password");
			String format = "jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
			String url=String.format(format,host,duan,db);
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, pass);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 单例模式获得Mysql唯一实例
	static public synchronized Mysql getInstance() {
		if (mysql == null) {
			mysql = new Mysql();
		}
		return mysql;
	}

	// 执行操作sql语句执行，返回ResultSet
	public synchronized ResultSet query(String sql) {
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// 操作sql语句执行，返回布尔值
	public synchronized boolean execute(String sql) {
		try {
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	// 更新语句执行，返回受影响的条目
	public synchronized int update(String sql) {
		try {
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			Logger.getLogger("travel").warning(e.getMessage());
			return -1;
		}
	}

	public synchronized boolean delete(String table, int id) {
		String sql = "DELETE FROM " + table + " WHERE id =" + id;
		return mysql.execute(sql);
	}

	// 单元测试之用
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Mysql mysql = Mysql.getInstance();
		String sql = "SELECT * from jindi_fiend";
		mysql.query(sql);
	}
}
