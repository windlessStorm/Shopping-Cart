package com.wipro.shopping.dao;

import com.wipro.shopping.bean.UserBean;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class LoginDao 
{
	String username, password,usertype;
	boolean flag=false;
	
	public boolean validUser(UserBean u)
	{
            username = u.getUserId();
            password = u.getPassword();
            
            UserBean user_login = new UserBean();
            
            user_login.setUserId(username);
            user_login.setPassword(password);
            
            
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
            Session session = sessionFactory.openSession();
            
            String hql = "from com.wipro.shopping.bean.UserBean U where U.userId=:username and U.password=:password";
            Query query = session.createQuery(hql);
            query.setParameter("username", user_login.getUserId());
            query.setParameter("password", user_login.getPassword());
            List result = query.list();

            Iterator iterator = result.iterator();
            while(iterator.hasNext())
            {
                flag=true;
                break;
            }
                
            
            session.close();
            
            return flag;
	}
	public boolean userAccess(UserBean u)
	{
            String access_level="";
            username = u.getUserId();
            password = u.getPassword();
		
            UserBean user_login = new UserBean();
            
            user_login.setUserId(username);
            user_login.setPassword(password);
            
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
            Session session = sessionFactory.openSession();
            
            String hql = "Select U.userType from com.wipro.shopping.bean.UserBean U where U.userId=:username and U.password=:password";      
            Query query = session.createQuery(hql);
            query.setParameter("username", user_login.getUserId());
            query.setParameter("password", user_login.getPassword());
            List<String> result = query.list();

            Iterator iterator = result.iterator();
            while(iterator.hasNext())
            {
                access_level = (String)iterator.next();
                break;
            }
            
            flag = "A".equalsIgnoreCase(access_level);
            
            session.close();
            
            return flag;
     }
}