package sla.dao;

import java.util.List;

import sla.bean.ComplaintLog;
import sla.bean.SpareMaster;
import sla.bean.SpareRequire;

public interface EngineerDao {
	public List<ComplaintLog> generateTicketDetailsDao();
	public List<SpareMaster> getSpareListDao();
	public boolean spareSaveDao(SpareRequire spare);
	public String generateRequireId();
}
