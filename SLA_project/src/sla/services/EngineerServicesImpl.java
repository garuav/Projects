package sla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sla.bean.ComplaintLog;
import sla.bean.SpareMaster;
import sla.bean.SpareRequire;
import sla.dao.EngineerDao;

@Component("engineerServices")
public class EngineerServicesImpl implements EngineerServices{
	private EngineerDao engineerDao;

	public EngineerDao getEngineerDao() {
		return engineerDao;
	}
@Autowired
	public void setEngineerDao(EngineerDao engineerDao) {
		this.engineerDao = engineerDao;
	}
@Override
public List<ComplaintLog> generateTicketDetails() {
	
	return engineerDao.generateTicketDetailsDao();
}
@Override
public List<SpareMaster> getSpareList() {
	
	return engineerDao.getSpareListDao();
}
@Override
public boolean spareSave(SpareRequire spare) {
	
	return engineerDao.spareSaveDao(spare);
}
@Override
public String generateRequireId() {
	return engineerDao.generateRequireId();
}
	

}
