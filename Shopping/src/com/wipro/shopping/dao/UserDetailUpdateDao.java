package com.wipro.shopping.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class UserDetailUpdateDao {
	boolean flag = false;
	
	public boolean updatePassword(String username, String old_password, String new_password)
	{
		
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
            Session session = sessionFactory.openSession();
            Transaction trx = session.beginTransaction();
            
            String hql = "update com.wipro.shopping.bean.UserBean U set U.password=:password where U.userId=:username";      
            Query query = session.createQuery(hql);
            query.setParameter("password", new_password);
            query.setParameter("username", username);
            int affected_rows = query.executeUpdate();
            
            if(affected_rows>0)
                flag=true;
            
            trx.commit();
            session.close();
            
            return flag;
	}
}
