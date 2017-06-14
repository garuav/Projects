package sla.services;

import java.util.List;


import sla.bean.ComplaintLog;
import sla.bean.SpareMaster;
import sla.bean.SpareRequire;


public interface EngineerServices {
	public List<ComplaintLog> generateTicketDetails();
	public List<SpareMaster> getSpareList();
	public boolean spareSave(SpareRequire spare);
	public String generateRequireId();
}
