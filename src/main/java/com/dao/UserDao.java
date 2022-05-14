package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.User;

public class UserDao {

	public static boolean insert(User u) {
		Connection con = null;
		PreparedStatement pst = null;
		boolean status = false;
		int result = 0;
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement("insert into Users values(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, u.getName());
			pst.setString(2, u.getAge());
			pst.setDate(3, new java.sql.Date((u.getDob()).getTime()));
			pst.setString(4, u.getLang());
			pst.setString(5, u.getGender());
			pst.setString(6, u.getUsername());
			pst.setString(7, u.getPassword());
			pst.setString(8, u.getEmail());
			pst.setString(9, u.getContact());
			pst.setString(10, u.getAddress());
			pst.setString(11, u.getType());
			result = pst.executeUpdate();
			if (result > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closePreparedStatement(pst);
			JDBCConnection.closeConnection(con);

		}
		return status;
	}

	public static boolean update(User u) {
		Connection con = null;
		PreparedStatement pst = null;
		boolean status = false;
		int result = 0;
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(
					"update Users set name=?,age=?,dob=?,lang=?,gender=?,username=?,password=?,email=?,contact=?,address=?,type=? where username=?");
			pst.setString(1, u.getName());
			pst.setString(2, u.getAge());
			pst.setDate(3, new java.sql.Date((u.getDob()).getTime()));
			pst.setString(4, u.getLang());
			pst.setString(5, u.getGender());
			pst.setString(6, u.getUsername());
			pst.setString(7, u.getPassword());
			pst.setString(8, u.getEmail());
			pst.setString(9, u.getContact());
			pst.setString(10, u.getAddress());
			pst.setString(11, u.getType());
			pst.setString(12, u.getUsername());
			result = pst.executeUpdate();
			if (result > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closePreparedStatement(pst);
			JDBCConnection.closeConnection(con);
		}

		return status;
	}

	public static boolean usernameCheck(String u) {
		boolean status = false;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {

			con = JDBCConnection.getConnection();
			pst = con.prepareStatement("select * from Users where username=?");
			pst.setString(1, u);
			 rs = pst.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closePreparedStatement(pst);
			JDBCConnection.closeConnection(con);
			JDBCConnection.closeResultSet(rs);
		}

		return status;
	}

	public static User logInCheck(User u) {
		// boolean status = false;

		Connection con = null;
		PreparedStatement pst = null;
		// int result = 0;
		// User u = new User();
		try {
			con = JDBCConnection.getConnection();

			pst = con.prepareStatement("select * from Users where username=? and password=?");
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			// status = rs.next();
			while (rs.next()) {
				u = new User();
				System.out.println("Name=" + rs.getString(1));
				u.setName(rs.getString(1));
				u.setAge(rs.getString(2));
				u.setDob(rs.getDate(3));
				u.setLang(rs.getString(4));
				u.setGender(rs.getString(5));
				u.setUsername(rs.getString(6));
				u.setPassword(rs.getString(7));
				u.setEmail(rs.getString(8));
				u.setContact(rs.getString(9));
				u.setAddress(rs.getString(10));
				u.setType(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closePreparedStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return u;

	}

	public static List<User> viewAll() {
		Connection con = null;
		PreparedStatement pst = null;
		List<User> userList = new ArrayList<>();
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement("select * from Users");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setName(rs.getString(1));
				u.setAge(rs.getString(2));
				u.setDob(rs.getDate(3));
				u.setLang(rs.getString(4));
				u.setGender(rs.getString(5));
				u.setUsername(rs.getString(6));
				u.setPassword(rs.getString(7));
				u.setEmail(rs.getString(8));
				u.setContact(rs.getString(9));
				u.setAddress(rs.getString(10));
				u.setType(rs.getString(11));
				userList.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.closePreparedStatement(pst);
			JDBCConnection.closeConnection(con);
		}

		return userList;
	}

	public static List<User> view(User u) {
		Connection con = null;
		PreparedStatement pst = null;
		List<User> userList = new ArrayList<>();
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement("select * from Users where username=? and password=?");
			pst.setString(1,u.getUsername());
			pst.setString(2,u.getPassword());

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				//User u = new User();
				u.setName(rs.getString(1));
				u.setAge(rs.getString(2));
				u.setDob(rs.getDate(3));
				u.setLang(rs.getString(4));
				u.setGender(rs.getString(5));
				u.setUsername(rs.getString(6));
				u.setPassword(rs.getString(7));
				u.setEmail(rs.getString(8));
				u.setContact(rs.getString(9));
				u.setAddress(rs.getString(10));
				u.setType(rs.getString(11));
				userList.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.closePreparedStatement(pst);
			JDBCConnection.closeConnection(con);
		}

		return userList;
	}
	public static boolean  delete(String s) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean status=false;
		int result = 0;
		try {
			con=JDBCConnection.getConnection();
			pst=con.prepareStatement("delete from Users where username=?");
			pst.setString(1,s);
			result=pst.executeUpdate();
			if(result>0) {
				status=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();	
		}
		finally {
			JDBCConnection.closePreparedStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return status;
	}
	public static boolean  deleteAll() {
		Connection con=null;
		PreparedStatement pst=null;
		boolean status=false;
		int result = 0;
		try {
			con=JDBCConnection.getConnection();
			pst=con.prepareStatement("delete * from Users");
			result=pst.executeUpdate();
			if(result>0) {
				status=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();	
		}
		finally {
			JDBCConnection.closePreparedStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return status;
	}
}
