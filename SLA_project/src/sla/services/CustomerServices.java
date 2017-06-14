package sla.services;

import sla.bean.ComplaintLog;
import sla.bean.Login;

public interface CustomerServices {
	public String generateTicketId();
	public boolean complaintSave(ComplaintLog complaint);

}
