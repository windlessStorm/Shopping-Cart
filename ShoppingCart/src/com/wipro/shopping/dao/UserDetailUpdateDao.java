package com.wipro.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.shopping.util.DBUtil;

public class UserDetailUpdateDao {
	boolean flag = false;
	
	public boolean updatePassword(String username, String old_password, String new_password)
	{
		Connection conn=DBUtil.getConnect();
		PreparedStatement ps;
		
		try 
		{
			ps = conn.prepareStatement("select * from Users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, old_password);
		
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ps = conn.prepareStatement("update Users set password=? where username=? and password=?");
				ps.setString(1, new_password);
				ps.setString(2, username);
				ps.setString(3, old_password);
			
				rs=ps.executeQuery();
				if(rs.next())
				{
					flag = true;
				}
			}
			
			conn.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
