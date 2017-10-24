package com.wipro.shopping.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
	public static Connection conn=null;
	public static Connection getConnect()
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception err){
			err.printStackTrace();
		}
		
		String cs = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(cs,"satyaki","qwerty");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; 
	}
	}
	


