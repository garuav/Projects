package sla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import sla.bean.ComplaintLog;
import sla.bean.Login;
import sla.services.CustomerServices;
@Controller
@SessionAttributes("loginSession")
public class CustomerController {
	private CustomerServices customerServices;

public CustomerServices getCustomerServices() {
		return customerServices;
	}
@Autowired
	public void setCustomerServices(CustomerServices customerServices) {
		this.customerServices = customerServices;
	}
@ModelAttribute("loginSession")
public Login getLoginSession(){
System.out.println("In @ModelAttribute(loginSession)");
	return new Login();	
}

@RequestMapping("compLog")
public ModelAndView complaintLog(Model model,@ModelAttribute("loginSession")Login login )
{
	if(login.getUserId()==null && login.getPassword()==null){
		model.addAttribute("msg", "Session is expired.");
		return new ModelAndView("../../index");
	}
	String ticketId=customerServices.generateTicketId();
ComplaintLog complaint=new ComplaintLog();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
complaint.setTicketDate(dateFormat.format(new Date()));
complaint.setTicketId(ticketId);
model.addAttribute("loginSession",login);
System.out.println("ID = "+login.getLogId());
System.out.println("username = "+login.getUserId());
System.out.println("type = "+login.getLogInType());

model.addAttribute("ticket", complaint);

	
	return new ModelAndView("customer/complaintLog");
}
@RequestMapping("warrantyInfo")
public ModelAndView warrantyInfo()
{
	return new ModelAndView("customer/warrantyInfo");
}
@RequestMapping("complaintStatus")
public ModelAndView complaintStatus()
{
	return new ModelAndView("customer/complaintStatus");
}

@RequestMapping("homeCst")
public ModelAndView homeCst()
{
	return new ModelAndView("customer/home");
}

@RequestMapping("complaintLog")
public String complaintLog(@ModelAttribute ComplaintLog complaint,ModelMap model,@ModelAttribute("loginSession")Login login )
{
	if(login.getUserId()==null && login.getPassword()==null){
		model.addAttribute("msg", "Session is expired.");
		return ("../../index");
	}
	if(customerServices.complaintSave(complaint))
		model.addAttribute("success","Complaint added Successfully with Ticket Id"+complaint.getTicketId());
	else
		model.addAttribute("error","Complaint not added with Ticket Id"+complaint.getTicketId());
	String ticketId=customerServices.generateTicketId();
	ComplaintLog comp=new ComplaintLog();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	comp.setTicketDate(dateFormat.format(new Date()));
	comp.setTicketId(ticketId);
	model.addAttribute("ticket", comp);
	model.addAttribute("loginSession",login);
	return "customer/complaintLog" ;
}
}