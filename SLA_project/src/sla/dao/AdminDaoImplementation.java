package sla.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import sla.bean.CustomerMaster;
import sla.bean.EmployeeMaster;
import sla.bean.LocationMaster;
import sla.bean.Login;
import sla.bean.ModelMaster;
import sla.bean.ProductMaster;
import sla.bean.SpareMaster;
import sla.bean.UnitMaster;
import sla.bean.WarrantyTracking;
import sla.dao.HibernateUtil;

@Component("adminDao")
public class AdminDaoImplementation implements AdminDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	@Override
	public boolean CustomerSaveDao(CustomerMaster customer) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			Login login=new Login();
			login.setLogId(customer.getCustomerId());
			login.setUserId(customer.getUserName());
			login.setPassword(customer.getPassword());
			login.setLogInType(customer.getCustomerType());
			tx=session.beginTransaction();
			session.saveOrUpdate(customer);
			session.saveOrUpdate(login);
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
	public List<CustomerMaster> getCustomerListDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM customermaster";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(CustomerMaster.class);
			@SuppressWarnings("unchecked")
			List<CustomerMaster>list = query.list();
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
	public CustomerMaster getCustomerEditDao(String customerId) {
		
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM customerMaster WHERE customerId='" + customerId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(CustomerMaster.class);
			CustomerMaster cst = (CustomerMaster)query.uniqueResult();
			
			return cst;
			
			
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
	public String generateCustomerId() {
		Session session = null;
		
		try
		{
			session = sf.openSession();
			String sql="SELECT customerId FROM customermaster ORDER BY customerId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String customerId = (String)query.uniqueResult();
			if(null==customerId)
			{
				return "CST101";
			}
			
			int cusId=Integer.parseInt(customerId.substring(3,customerId.length()));
			cusId++;
			return "CST"+cusId;
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
	public boolean deleteCustomer(String customerId) {

		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			String sqlCustomer="Delete FROM customermaster where customerId='"+customerId+"'";
			String sqlLogin="Delete FROM login where logId='"+customerId+"'";
			SQLQuery query = session.createSQLQuery(sqlCustomer);
			SQLQuery query1= session.createSQLQuery(sqlLogin);
			query.executeUpdate();
			query1.executeUpdate();
			tx.commit();
				return true;			
		} 
		catch (HibernateException ex) 
		{
			tx.rollback();
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
	public boolean EmployeeSaveDao(EmployeeMaster employee) {
		Session session = null;
		Transaction tx=null;
		try
		{
			
			session = sf.openSession();
			Login login=new Login();
			login.setLogId(employee.getEmpId());
			login.setUserId(employee.getUserName());
			login.setPassword(employee.getPassword());
			login.setLogInType(employee.getEmpType());
			tx=session.beginTransaction();
			session.saveOrUpdate(employee);
			session.saveOrUpdate(login);
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
	public String generateEmployeeId() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT empId FROM employeemaster ORDER BY empId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String empId = (String)query.uniqueResult();
			if(null==empId)
			{
				return "EMP101";
			}
			
			int emplId=Integer.parseInt(empId.substring(3,empId.length()));
			emplId++;
			return "EMP"+emplId;
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
	public List<EmployeeMaster> getEmployeeListDao() {
		Session session = null;
		
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM employeemaster";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(EmployeeMaster.class);
			@SuppressWarnings("unchecked")
			List<EmployeeMaster>list = query.list();
			
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
	public boolean modelSaveDao(ModelMaster modelMas) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(modelMas);
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
	public String generateModelId() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT modelId FROM modelmaster ORDER BY modelId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String modelId = (String)query.uniqueResult();
			if(null==modelId)
			{
				return "MOD101";
			}
			
			int modId=Integer.parseInt(modelId.substring(3,modelId.length()));
			modId++;
			return "MOD"+modId;
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
	public List<ModelMaster> getModelListDao() {
Session session = null;
		
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM modelmaster";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ModelMaster.class);
			@SuppressWarnings("unchecked")
			List<ModelMaster>list = query.list();
			
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
	public boolean productSaveDao(ProductMaster product) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(product);
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
	public String generateProductId() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT productId FROM productmaster ORDER BY productId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String productId = (String)query.uniqueResult();
			if(null==productId)
			{
				return "PR101";
			}
			
			int product=Integer.parseInt(productId.substring(2,productId.length()));
			product++;
			return "PR"+product;
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
	public List<ProductMaster> getProductListDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM productmaster";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ProductMaster.class);
			@SuppressWarnings("unchecked")
			List<ProductMaster>list = query.list();
			
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
	public List<CustomerMaster> generateCustomerDetailsDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM customermaster ";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(CustomerMaster.class);
			@SuppressWarnings("unchecked")
			List<CustomerMaster> cst = query.list();
			return cst;
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
	public CustomerMaster getCustomerAddressDao(String customerId) {
		Session session = null;
		
		try
		{
			session = sf.openSession();
			
			String sql="SELECT houseNo,society,locality,city,state FROM customermaster where userName='"+customerId+"'";
			SQLQuery query = session.createSQLQuery(sql);
			@SuppressWarnings("unchecked")
			List<Object[]>list =  query.list();
			CustomerMaster cust=new CustomerMaster();
			for (Object[] obj : list) {
				cust.setHouseNo((String)obj[0]);
				cust.setSociety((String)obj[1]);
				cust.setLocality((String)obj[2]);
				cust.setCity((String)obj[3]);
				cust.setState((String)obj[4]);
			}
			return cust;
			
			
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
	public List<ProductMaster> generateProductDetailsDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM productmaster ";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ProductMaster.class);
			@SuppressWarnings("unchecked")
			List<ProductMaster> prd = query.list();
			return prd;
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
	public boolean spareSaveDao(SpareMaster spare) {
		Session session = null;
		Transaction tx=null;
		try
		{
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
	public String generateSpareId() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT spareId FROM spareMaster ORDER BY spareId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String spareId = (String)query.uniqueResult();
			if(null==spareId)
			{
				return "SP101";
			}
			
			int spare=Integer.parseInt(spareId.substring(2,spareId.length()));
			spare++;
			return "SP"+spare;
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
	public List<ModelMaster> generateModelDetailsDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM modelmaster ";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ModelMaster.class);
			@SuppressWarnings("unchecked")
			List<ModelMaster> modl = query.list();
			return modl;
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
	public ProductMaster productEditDao(String productId) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM productMaster WHERE productId='" + productId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ProductMaster.class);
			ProductMaster pro = (ProductMaster)query.uniqueResult();
			
			return pro;
			
			
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
	public EmployeeMaster employeeEditDao(String empId) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM employeeMaster WHERE empId='" + empId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(EmployeeMaster.class);
			EmployeeMaster emp = (EmployeeMaster)query.uniqueResult();
			
			return emp;
			
			
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
	public boolean deleteEmployeeDao(String empId) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			String sqlEmp="Delete FROM employeemaster where empId='"+empId+"'";
			String sqlLogin="Delete FROM login where logId='"+empId+"'";
			SQLQuery query = session.createSQLQuery(sqlEmp);
			SQLQuery query1 = session.createSQLQuery(sqlLogin);
			query.executeUpdate();
			query1.executeUpdate();
			tx.commit();
				return true;			
		} 
		catch (HibernateException ex) 
		{
			tx.rollback();
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
	public boolean locationSaveDao(LocationMaster locationMas) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(locationMas);
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
	public String generateLocationIdDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT locationId FROM locationMaster ORDER BY locationId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String locationId = (String)query.uniqueResult();
			if(null==locationId)
			{
				return "LOC101";
			}
			
			int location=Integer.parseInt(locationId.substring(3,locationId.length()));
			location++;
			return "LOC"+location;
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
	public List<LocationMaster> getLocationListDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM locationMaster";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(LocationMaster.class);
			@SuppressWarnings("unchecked")
			List<LocationMaster>list = query.list();
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
	public LocationMaster locationEditDao(String locationId) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM locationMaster WHERE locationId='" + locationId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(LocationMaster.class);
			LocationMaster loc = (LocationMaster)query.uniqueResult();
			
			return loc;
			
			
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
	public boolean deleteLocation(String locationId) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			String sqlEmp="Delete FROM locationMaster where locationId='"+locationId+"'";
			SQLQuery query = session.createSQLQuery(sqlEmp);
			query.executeUpdate();
			tx.commit();
				return true;			
		} 
		catch (HibernateException ex) 
		{
			tx.rollback();
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
	public ModelMaster modelEditDao(String modelId) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM modelMaster WHERE modelId='" + modelId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ModelMaster.class);
			ModelMaster mod = (ModelMaster)query.uniqueResult();
			
			return mod;
			
			
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
	public boolean deleteModel(String modelId) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			String sqlModel="Delete FROM modelMaster where modelId='"+modelId+"'";
			SQLQuery query = session.createSQLQuery(sqlModel);
			query.executeUpdate();
			tx.commit();
				return true;			
		} 
		catch (HibernateException ex) 
		{
			tx.rollback();
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
	public boolean deleteProduct(String productId) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			String sqlModel="Delete FROM productMaster where productId='"+productId+"'";
			SQLQuery query = session.createSQLQuery(sqlModel);
			query.executeUpdate();
			tx.commit();
				return true;			
		} 
		catch (HibernateException ex) 
		{
			tx.rollback();
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
	public boolean unitSaveDao(UnitMaster unitMas) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(unitMas);
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
	public String generateUnitId() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT unitId FROM unitMaster ORDER BY unitId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String unitId = (String)query.uniqueResult();
			if(null==unitId)
			{
				return "UNIT101";
			}
			
			int unit=Integer.parseInt(unitId.substring(4,unitId.length()));
			unit++;
			return "UNIT"+unit;
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
	public List<UnitMaster> getUnitListDao() {
Session session = null;
		
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM unitMaster";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(UnitMaster.class);
			@SuppressWarnings("unchecked")
			List<UnitMaster>list = query.list();
			
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
	public UnitMaster unitEditDao(String unitId) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM unitMaster WHERE unitId='" + unitId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(UnitMaster.class);
			UnitMaster unit = (UnitMaster)query.uniqueResult();
			
			return unit;
			
			
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
		}	}

	@Override
	public boolean deleteUnit(String unitId) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			String sqlModel="Delete FROM unitMaster where unitId='"+unitId+"'";
			SQLQuery query = session.createSQLQuery(sqlModel);
			query.executeUpdate();
			tx.commit();
				return true;			
		} 
		catch (HibernateException ex) 
		{
			tx.rollback();
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
	public SpareMaster spareEditDao(String spareId) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM spareMaster WHERE spareId='" + spareId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(SpareMaster.class);
			SpareMaster spr = (SpareMaster)query.uniqueResult();
			
			return spr;
			
			
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
	public boolean deleteSpare(String spareId) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			String sqlSpare="Delete FROM spareMaster where spareId='"+spareId+"'";
			SQLQuery query = session.createSQLQuery(sqlSpare);
			query.executeUpdate();
			tx.commit();
				return true;			
		} 
		catch (HibernateException ex) 
		{
			tx.rollback();
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean getCstUserName(String userName) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT userName FROM customermaster ";
			
			SQLQuery query = session.createSQLQuery(sql);
			
			List<String>list =(ArrayList<String>)query.list();
			String flag="";
			for(String cst:list)
			{
			if(userName.equals(cst))
			{
				
				flag="true";
			break;
				
			}
			else
			{
				flag="";
			}
			}
			if(flag!="")
				return true;
			else 
				return false;
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
	public boolean warrantySaveDao(WarrantyTracking warranty) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(warranty);
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
	public String generateDocId() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT docId FROM warrantyTracking ORDER BY docId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String docId = (String)query.uniqueResult();
			if(null==docId)
			{
				return "DOC101";
			}
			
			int doc=Integer.parseInt(docId.substring(3,docId.length()));
			doc++;
			return "DOC"+doc;
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
	public List<WarrantyTracking> getWarrantyListDao() {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM warrantyTracking";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(WarrantyTracking.class);
			@SuppressWarnings("unchecked")
			List<WarrantyTracking>list = query.list();
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
	public WarrantyTracking warrantyEditDao(String docId) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM warrantyTracking WHERE docId='" + docId + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(WarrantyTracking.class);
			WarrantyTracking wrr = (WarrantyTracking)query.uniqueResult();
			
			return wrr;
			
			
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
	public boolean deleteWarranty(String docId) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			String sqlCustomer="Delete FROM warrantyTracking where docId='"+docId+"'";
			SQLQuery query = session.createSQLQuery(sqlCustomer);
			query.executeUpdate();
			tx.commit();
				return true;			
		} 
		catch (HibernateException ex) 
		{
			tx.rollback();
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

	


