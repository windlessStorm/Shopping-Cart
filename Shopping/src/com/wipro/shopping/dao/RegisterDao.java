package com.wipro.shopping.dao;

import com.wipro.shopping.bean.UserBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
		
		UserBean user_register = new UserBean();
		
		user_register.setUserId(username);
		user_register.setPassword(password);
		user_register.setName(name);
		user_register.setEmail(email);
		user_register.setCity(city);
		user_register.setUserType(usertype);
		
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
            Session session = sessionFactory.openSession();
            Transaction trx = session.beginTransaction();

            session.save(user_register);//persisting the object

            trx.commit();//transaction is commited
            session.close();
            flag=true;    
            return flag;
	}
}

