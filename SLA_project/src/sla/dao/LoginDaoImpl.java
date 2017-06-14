package sla.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


import sla.bean.Login;

@Component("loginDao")
public class LoginDaoImpl implements LoginDao{
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	@Override
	public String validLoginDao(Login l) 
	{
		
		
		
			Session session = null;
			try
			{
				session = sf.openSession();
				String sql="SELECT * FROM login where userId='"+l.getUserId()+"'&& password='"+l.getPassword()+"'";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(Login.class);
				@SuppressWarnings("unchecked")
				List<Login> list=query.list();
				String info=null;
				
				if((list!=null)&&(list.size()>0))
				{
					for(Login log:list)
					{
					
					if(log.getLogInType().equals("Individual")|| log.getLogInType().equals("Corporate"))
					{
						info= "customer";
						
					}
					else if(log.getLogInType().equals("Admin"))
					{
						info= "admin";
					}
					else if(log.getLogInType().equals("Manager"))
						info="manager";
					else if(log.getLogInType().equals("Telecaller"))
						info= "telecaller";
					else if(log.getLogInType().equals("Engineer"))
						info= "engineer";
					
								
				}}
				
					return info;
				}
				
				
				
			
			catch (HibernateException ex) 
			{
				ex.printStackTrace();	
				return null;
			}
			finally 
			{
				if (session != null)
					session.close();
			}
		}
		

}
