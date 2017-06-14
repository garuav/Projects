package sla.services;

import java.util.List;

import sla.bean.ComplaintLog;


public interface TelecallerServices {
	public List<ComplaintLog> complaintList();
	public ComplaintLog assignComplaint(String ticketId);
}
