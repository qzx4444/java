package cn.qi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:MYSQL://localhost£»3306/youwante";
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet  rs = null;
	private String username = "root";
	private String password = "root";
	
	public DB()
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private Connection getConnection() {
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public int myUpdate(String sql) {
		int c = 0;
		try {
			this.stmt = this.getConnection().createStatement();
			c = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();
		return c;
	}

	public ResultSet mySelect(String sql) {
		try {
			this.stmt = this.getConnection().createStatement();
			this.rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
