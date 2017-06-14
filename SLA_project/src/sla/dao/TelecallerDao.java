package sla.dao;

import java.util.List;

import sla.bean.ComplaintLog;

public interface TelecallerDao {
	public List<ComplaintLog> complaintListDao();
	public ComplaintLog assignComplaint(String ticketId);
}
