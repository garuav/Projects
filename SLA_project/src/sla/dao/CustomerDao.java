package sla.dao;

import sla.bean.ComplaintLog;
import sla.bean.Login;

public interface CustomerDao {
	public String generateTicketId();
	public boolean complaintSaveDao(ComplaintLog complaint);

}
