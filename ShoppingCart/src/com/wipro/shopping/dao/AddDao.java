package com.wipro.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.shopping.bean.MobileBean;
import com.wipro.shopping.util.DBUtil;

public class AddDao {
	boolean flag=false;
	String modelNumber,modelName;
	int price;
	ArrayList<MobileBean> model_info = new ArrayList<>();
	
	public boolean addMobile(MobileBean mobileAdd)
	{
		Connection conn=DBUtil.getConnect();
		PreparedStatement ps;
		modelNumber = mobileAdd.getModelNumber();
		modelName = mobileAdd.getModelName();
		price = mobileAdd.getPrice();
		
		
		try {
			ps = conn.prepareStatement("insert into mobiles values(?,?,?)");
			ps.setString(1, modelNumber);
			ps.setString(2, modelName);
			ps.setInt(3, price);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			flag=true;
		}
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return flag;
	}
	
	public ArrayList<MobileBean> getModelInfo()
	{
		Connection conn=DBUtil.getConnect();
		PreparedStatement ps;
		String modelNumber,modelName;
		int price;
		
		try 
		{
			ps = conn.prepareStatement("select * from mobiles");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				modelNumber=rs.getString(1);
				modelName=rs.getString(2);
				price=rs.getInt(3);
				MobileBean mobile = new MobileBean();
				mobile.setModelNumber(modelNumber);
				mobile.setModelName(modelName);
				mobile.setPrice(price);
				
				model_info.add(mobile);	
			}
			conn.close();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model_info;
	}
	public boolean deletemobile(String modelnumber)
	{
		Connection conn=DBUtil.getConnect();
		PreparedStatement ps;
		try 
		{
			ps = conn.prepareStatement("delete from mobiles where modelnumber=?");
			ps.setString(1, modelnumber);
			int z=ps.executeUpdate();
			if(z>0)
			{
				flag = true;	
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
	public boolean modifyMobile(String modelnum, MobileBean mobileAdd)
	{
		Connection conn=DBUtil.getConnect();
		PreparedStatement ps;
		modelNumber = mobileAdd.getModelNumber();
		modelName = mobileAdd.getModelName();
		price = mobileAdd.getPrice();
		
		try 
		{
			
			ps = conn.prepareStatement("update mobiles set modelnumber=?, modelname=?, price =? where modelnumber=?");
			ps.setString(1, modelNumber);
			ps.setString(2, modelName);
			ps.setInt(3, price);
			ps.setString(4, modelnum);
			int z=ps.executeUpdate();
			if(z>0)
			{
				flag = true;	
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
