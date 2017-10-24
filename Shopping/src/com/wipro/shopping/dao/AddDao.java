package com.wipro.shopping.dao;

import java.util.ArrayList;

import com.wipro.shopping.bean.MobileBean;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AddDao {
	boolean flag=false;
	String modelNumber,modelName;
	int price;
	ArrayList<MobileBean> model_info = new ArrayList<>();
	
	public boolean addMobile(MobileBean mobileAdd)
	{
		modelNumber = mobileAdd.getModelNumber();
		modelName = mobileAdd.getModelName();
		price = mobileAdd.getPrice();
		
                MobileBean newMobile = new MobileBean();
                newMobile.setModelNumber(modelNumber);
                newMobile.setModelName(modelName);
                newMobile.setPrice(price);
                
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
            Session session = sessionFactory.openSession();
            Transaction trx = session.beginTransaction();

            session.save(newMobile);//persisting the object

            trx.commit();//transaction is commited
            session.close();
            flag = true;
            return flag;
	}
	
	public ArrayList<MobileBean> getModelInfo()
	{
		Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
                Session session = sessionFactory.openSession();
                Transaction trx = session.beginTransaction();
                
                String hql = "from com.wipro.shopping.bean.MobileBean";
                Query query = session.createQuery(hql);
                model_info = new ArrayList<>(query.list());
                
                /*
                Iterator iterator = result.iterator();
                while(iterator.hasNext())
                {
                    model_info.add(e);
                }
                */
                session.close();
                
		return model_info;
	}
	public boolean deletemobile(String modelnumber)
	{
		Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
                Session session = sessionFactory.openSession();
                Transaction trx = session.beginTransaction();
                
                String hql = "delete from com.wipro.shopping.bean.MobileBean M"
                        + "where M.modelNumber=:modelnumber";
                Query query = session.createQuery(hql);
                query.setParameter("modelnumber", modelnumber);
                int affected_rows = query.executeUpdate();

                if(affected_rows>0)
                    flag=true;

                trx.commit();
                session.close();
		return flag;
	}
	public boolean modifyMobile(String modelnum, MobileBean mobileAdd)
	{
		modelNumber = mobileAdd.getModelNumber();
		modelName = mobileAdd.getModelName();
		price = mobileAdd.getPrice();
		Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
                Session session = sessionFactory.openSession();
                Transaction trx = session.beginTransaction();

                String hql = "update com.wipro.shopping.bean.MobileBean M"
                        + " set M.modelNumber=:modelnumber, M.modelName=:modelname, M.price=:price"
                        + "where M.modelNumber=:modelnumber";      
                Query query = session.createQuery(hql);
                query.setParameter("modelnumber", modelNumber);
                query.setParameter("modelname", modelName);
                query.setParameter("price", price);
                query.setParameter("modelnumber", modelnum);

                int affected_rows = query.executeUpdate();

                if(affected_rows>0)
                    flag=true;

                trx.commit();
                session.close();
		return flag;
	}
}
