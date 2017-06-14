package sla.dao;


import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import sla.bean.ComplaintLog;
import sla.bean.Login;

@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao{
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	@Override
	public String generateTicketId() {
Session session = null;
		
		try
		{
			session = sf.openSession();
			String sql="SELECT ticketId FROM complaintLog ORDER BY ticketId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String ticketId = (String)query.uniqueResult();
			if(null==ticketId)
			{
				return "TKT101";
			}
			System.out.println(ticketId.substring(3,ticketId.length()));
			int tktId=Integer.parseInt(ticketId.substring(3,ticketId.length()));
			tktId++;
			return "TKT"+tktId;
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
	@Override
	public boolean complaintSaveDao(ComplaintLog complaint) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(complaint);
			tx.commit();
			return true;
			
		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}
	
	}
	
	

