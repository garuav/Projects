package sla.bean;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="complaintLog")
public class ComplaintLog {
	private String customerName;
	@Id
	private String customerId;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	private String ticketId;
	@DateTimeFormat(pattern = "dd.MM.yyyy ")
	private String ticketDate;
	private String equipmentNo;
	private String complaintDetails;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}
	public String getEquipmentNo() {
		return equipmentNo;
	}
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	
	public String getComplaintDetails() {
		return complaintDetails;
	}
	public void setComplaintDetails(String complaintDetails) {
		this.complaintDetails = complaintDetails;
	}
	

}
