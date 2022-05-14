package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName(JdbcPassword.DRIVER_CLASS);
			System.out.println("-----Driver class loaded----");
			con=DriverManager.getConnection(JdbcPassword.URL,JdbcPassword.USER,JdbcPassword.PSWD);
			System.out.println("-----connection called-");

		}catch (Exception e) {
e.printStackTrace();		}
		return con;
		
	}
	//connection close
	public static void closeConnection(Connection con)
	{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	//prepared statement close
	public static void closePreparedStatement(PreparedStatement ps)
	{
	try {
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	//resulset close

}
