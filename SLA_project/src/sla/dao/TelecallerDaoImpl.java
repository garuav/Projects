package sla.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import sla.bean.ComplaintLog;
import sla.bean.CustomerMaster;


@Component("telecallerDao")
public class TelecallerDaoImpl implements TelecallerDao{
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	@Override
	public List<ComplaintLog> complaintListDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM complaintLog";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ComplaintLog.class);
			@SuppressWarnings("unchecked")
			List<ComplaintLog>list = query.list();
			return list;
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
	public ComplaintLog assignComplaint(String ticketId) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM complaintLog WHERE ticketId='" + ticketId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ComplaintLog.class);
			ComplaintLog complaint = (ComplaintLog)query.uniqueResult();
			
			return complaint;
			
			
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
