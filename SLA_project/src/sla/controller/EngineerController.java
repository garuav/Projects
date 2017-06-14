package sla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sla.bean.ComplaintLog;

import sla.bean.SpareRequire;
import sla.services.EngineerServices;


@Controller

public class EngineerController {
	private EngineerServices engineerServices;
public EngineerServices getEngineerServices() {
		return engineerServices;
	}
@Autowired
	public void setEngineerServices(EngineerServices engineerServices) {
		this.engineerServices = engineerServices;
	}
@RequestMapping("complaintLogin")
public ModelAndView complaintLogin()
{
	return new ModelAndView("engineer/complaintLoginView");
}

@RequestMapping("utilizationReport")
public ModelAndView utilizationReport()
{
	return new ModelAndView("engineer/utilizationReport");
}
@RequestMapping("homeEng")
public ModelAndView homeEng()
{
	return new ModelAndView("engineer/home");
}

@RequestMapping("jobCard")
public ModelAndView jobCard(ModelMap model)
{
	List<ComplaintLog> ticketDetails=engineerServices.generateTicketDetails();
model.addAttribute("ticketList", ticketDetails);

	return new ModelAndView("engineer/jobCardEntry");
}
@RequestMapping("spareRate")
public ModelAndView spareRate()
{
	return new ModelAndView("engineer/spareRate","spareRate",engineerServices.getSpareList());
}
@RequestMapping("warrantyInfoEng")
public ModelAndView warrantyInfoEng()
{
	return new ModelAndView("engineer/warrantyInfo");
}

@RequestMapping("spareReq")
public ModelAndView spareReq(ModelMap model)
{
	String requireId=engineerServices.generateRequireId();
	SpareRequire require=new SpareRequire();
	require.setRequireId(requireId);
	model.addAttribute("require", require);
	return new ModelAndView("engineer/spareRequire");
}
@RequestMapping("spareRequire")
public String spareRequire(@ModelAttribute SpareRequire spare,ModelMap model)
{
	if(engineerServices.spareSave(spare))
		model.addAttribute("success","Spare added Successfully with Id "+spare.getRequireId());
	else
		model.addAttribute("error","Spare not added with Id "+spare.getRequireId());
	String requireId=engineerServices.generateRequireId();
	SpareRequire require=new SpareRequire();
	require.setRequireId(requireId);
	model.addAttribute("require", require);
	return "engineer/spareRequire" ;
}
}
