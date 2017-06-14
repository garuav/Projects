package sla.dao;




import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import sla.bean.AddSpare;
import sla.bean.ComplaintLog;

import sla.bean.SpareMaster;
import sla.bean.SpareRequire;




@Component("engineerDao")
public class EngineerDaoImpl implements EngineerDao{
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	@Override
	public List<ComplaintLog> generateTicketDetailsDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM complaintLog ";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ComplaintLog.class);
			@SuppressWarnings("unchecked")
			List<ComplaintLog> tkt = query.list();
			return tkt;
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
	public List<SpareMaster> getSpareListDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM spareMaster";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(SpareMaster.class);
			@SuppressWarnings("unchecked")
			List<SpareMaster>list = query.list();
			
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
	public boolean spareSaveDao(SpareRequire spare) {
		Session session = null;
		Transaction tx=null;
		System.out.println("size = "+spare.getSpr().size());
		try
		{
			
			
			for(int i=0;i<spare.getSpr().size();i++)
			{
				
				if(0!=spare.getSpr().get(i).getSrNo())
				{	
					
					spare.getSpr().get(i).setRequire(spare);
					
				}
				
				else{
					
					spare.getSpr().remove(i);
					i--;
				}
			}
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(spare);
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
	@Override
	public String generateRequireId() {
Session session = null;
		
		try
		{
			session = sf.openSession();
			String sql="SELECT requireId FROM spareRequire ORDER BY requireId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String requireId = (String)query.uniqueResult();
			if(null==requireId)
			{
				return "REQ101";
			}
			System.out.println(requireId.substring(3,requireId.length()));
			int reqId=Integer.parseInt(requireId.substring(3,requireId.length()));
			reqId++;
			return "REQ"+reqId;
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
