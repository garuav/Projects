package sla.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sla.services.TelecallerServicesImpl;

@Controller

public class TelecallerController {
	private TelecallerServicesImpl telecallerServices;
	public TelecallerServicesImpl getTelecallerServices() {
		return telecallerServices;
	}
	@Autowired
	public void setTelecallerServices(TelecallerServicesImpl telecallerServices) {
		this.telecallerServices = telecallerServices;
	}

	
	@RequestMapping("assignComplaint")
	public ModelAndView assignComplaint()
	{
		return new ModelAndView("telecaller/assignComplaint");
	}
	@RequestMapping("homeTele")
	public ModelAndView homeTele()
	{
		return new ModelAndView("telecaller/home");
	}
	
	@RequestMapping("complaintLoginView")
	public ModelAndView complaintLoginView()
	{
		
		return new ModelAndView("telecaller/complaintLogView","complaintList",telecallerServices.complaintList());		
	}
	@RequestMapping("assign")
	public ModelAndView assign(@RequestParam String ticketId)
	{
		
		return new ModelAndView("telecaller/assignComplaint","editComplaint",telecallerServices.assignComplaint(ticketId));		
	}
	@RequestMapping("warrantyInfoTele")
	public ModelAndView warrantyInfoTele()
	{
		return new ModelAndView("telecaller/warrantyInfo");
	}
}
