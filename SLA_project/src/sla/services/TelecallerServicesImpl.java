package sla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sla.bean.ComplaintLog;
import sla.dao.TelecallerDaoImpl;

@Component("telecallerServices")
public class TelecallerServicesImpl implements TelecallerServices{
private TelecallerDaoImpl telecallerDao;

public TelecallerDaoImpl getTelecallerDao() {
	return telecallerDao;
}
@Autowired
public void setTelecallerDao(TelecallerDaoImpl telecallerDao) {
	this.telecallerDao = telecallerDao;
}
@Override
public List<ComplaintLog> complaintList() {
	
	return telecallerDao.complaintListDao();
}
@Override
public ComplaintLog assignComplaint(String ticketId) {
	
	return telecallerDao.assignComplaint(ticketId);
}

}
