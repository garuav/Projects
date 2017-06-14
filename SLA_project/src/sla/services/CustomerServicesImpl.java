package sla.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sla.bean.ComplaintLog;
import sla.bean.Login;
import sla.dao.CustomerDaoImpl;

@Component("customerServices")
public class CustomerServicesImpl implements CustomerServices{
private CustomerDaoImpl customerDao;
	public CustomerDaoImpl getCustomerDao() {
	return customerDao;
}
	@Autowired
public void setCustomerDao(CustomerDaoImpl customerDao) {
	this.customerDao = customerDao;
}
	@Override
	public String generateTicketId() {
		
		return customerDao.generateTicketId();
	}
	@Override
	public boolean complaintSave(ComplaintLog complaint) {
		
		return customerDao.complaintSaveDao(complaint);
	}
	

}
