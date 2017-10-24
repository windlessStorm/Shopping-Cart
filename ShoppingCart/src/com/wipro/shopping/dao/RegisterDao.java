package com.wipro.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wipro.shopping.util.*;
import com.wipro.shopping.bean.UserBean;

public class RegisterDao 
{
	public boolean registerUser(UserBean u)
	{
		String username, password, name, email, city, usertype;
		boolean flag=false;
		
		username = u.getUserId();
		password = u.getPassword();
		name = u.getName();
		email = u.getEmail();
		city = u.getCity();
		usertype = u.getUserType();
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
		
		//creating seession factory object
		SessionFactory factory=cfg.buildSessionFactory();
		
		//creating session object
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		UserBean user_register = new UserBean();
		
		user_register.setUserId(username);
		user_register.setPassword(password);
		user_register.setName(name);
		user_register.setEmail(email);
		user_register.setCity(city);
		user_register.setUserType(usertype);
		
		session.saveOrUpdate(user_register);//persisting the object
		
		t.commit();//transaction is commited
		session.close();
		
		/*
		Connection conn=DBUtil.getConnect();
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement("Insert into Users values(?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, city);
			ps.setString(6, usertype);
			
			int y=ps.executeUpdate();
			if(y>0)
			{
				flag=true;
			}
		
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return flag;
	}
}

