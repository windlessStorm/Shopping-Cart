package com.wipro.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.shopping.bean.UserBean;
import com.wipro.shopping.util.DBUtil;

public class LoginDao {
	String username, password,usertype;
	boolean flag=false;
	
	public boolean validUser(UserBean u)
	{
		username = u.getUserId();
		password = u.getPassword();
		
		Connection conn=DBUtil.getConnect();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
	}
	public boolean userAccess(UserBean u)
	{
		username = u.getUserId();
		password = u.getPassword();
		
		Connection conn=DBUtil.getConnect();
		PreparedStatement ps;
		username = u.getUserId();
		password = u.getPassword();
		
		try {
			ps = conn.prepareStatement("select usertype from Users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
		
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				usertype = rs.getString(1);
			}
			conn.close();
		} 
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		if(usertype.equalsIgnoreCase("A"))
			flag=true;
		else
			flag=false;
		return flag;
	}

}
