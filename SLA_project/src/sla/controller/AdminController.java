package sla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sla.services.LoginServiceImpl;
import sla.bean.CustomerMaster;
import sla.bean.EmployeeMaster;
import sla.bean.LocationMaster;
import sla.bean.Login;
import sla.bean.ModelMaster;
import sla.bean.ProductMaster;
import sla.bean.SpareMaster;
import sla.bean.UnitMaster;
import sla.bean.WarrantyTracking;
import sla.services.AdminServicesImplementation;

@Controller
@SessionAttributes("loginSession")
public class AdminController {
	
	private LoginServiceImpl loginImpl;
	
	public LoginServiceImpl getLogin() {
		return loginImpl;
	}
	@Autowired
	public void setLogin(LoginServiceImpl login) {
		this.loginImpl = login;
	}
	private AdminServicesImplementation adminServices;
	
	public AdminServicesImplementation getAdminServices() {
		return adminServices;
	}
	@Autowired
	public void setAdminServices(AdminServicesImplementation adminServices) {
		this.adminServices = adminServices;
	}
	@ModelAttribute("loginSession")
	public Login getLoginSession(){
	System.out.println("In @ModelAttribute(loginSession)");
		return new Login();	
	}
	@RequestMapping("loginBack")
	public ModelAndView loginBack()
	{
		return new ModelAndView("../../index");
	}
	@RequestMapping("home")
	public ModelAndView home()
	{
		return new ModelAndView("admin/home");
	}
	@RequestMapping("navtest")
	public ModelAndView navtest()
	{
		return new ModelAndView("admin/navlink");
	}
	
	@RequestMapping("customerMaster")
	public ModelAndView customerMaster(@ModelAttribute("loginSession")Login login,ModelMap model)
	{
		if(login.getUserId()==null && login.getPassword()==null){
			model.addAttribute("msg", "Session is expired.");
			return new ModelAndView("../../index");
		}
		String customerId=adminServices.generateCustomerId();
		CustomerMaster cus=new CustomerMaster();
		cus.setCustomerId(customerId);
		model.addAttribute("customer", cus);
		return new ModelAndView("admin/CustomerMaster");
	}
	@RequestMapping("dashboard")
	public String login(@ModelAttribute Login login,ModelMap model)
	{
		String info=loginImpl.validLogin(login);
		if(info=="admin")
		{	
			model.addAttribute("loginSession",login);
			return ("admin/home");
		}
		
		else if(info=="customer")
		{	model.addAttribute("loginSession",login);
			System.out.println("Hello Customer");
			return ("customer/home");
		}
		else if(info=="telecaller")
		{
			model.addAttribute("loginSession",login);
			return("telecaller/home");
		}
		else if(info=="engineer")
		{
			model.addAttribute("loginSession",login);
			return("engineer/home");
		}
		else if(info=="manager")
			{
			model.addAttribute("loginSession",login);
			return("manager/home");
			}
		else
			{model.addAttribute("msg","Please Enter Valid Credentials !!");
			System.out.println("Hello Customer else");
			return "../../index";
			}
	}
	@RequestMapping("CustomerRegstration")
	public String CustomerRegistration(@ModelAttribute CustomerMaster customer,ModelMap model,@ModelAttribute("loginSession")Login login)
	{
		if(login.getUserId()==null && login.getPassword()==null){
			model.addAttribute("msg", "Session is expired.");
			return "../../index";
		}
		if(adminServices.CustomerSave(customer))
			model.addAttribute("success","Customer added Successfully with Id"+customer.getCustomerId());
		else
			model.addAttribute("error","Customer not added with Id"+customer.getCustomerId());
		String customerId=adminServices.generateCustomerId();
		CustomerMaster cus=new CustomerMaster();
		cus.setCustomerId(customerId);
		model.addAttribute("customer", cus);
		
		return "admin/CustomerMaster" ;
	}
	
	@RequestMapping("getCustomer")
	public ModelAndView viewCustomer(@ModelAttribute("loginSession")Login login,ModelMap model)
	{

		if(login.getUserId()==null && login.getPassword()==null){
			model.addAttribute("msg", "Session is expired.");
			return new ModelAndView("../../index");
		}
		return new ModelAndView("admin/customerShow","customerList",adminServices.getCustomerList());
		
	}
	@RequestMapping("editCustomer")
	public String editCustomer(@RequestParam String customerId,ModelMap model)
	{
		CustomerMaster customer= adminServices.getCustomerEdit(customerId);
		model.addAttribute("customer",customer);
		return "admin/customerEdit";
	}
@RequestMapping("employeeMaster")
public ModelAndView empMaster(ModelMap model)
{
	String empId=adminServices.generateEmployeeId();
	EmployeeMaster emp=new EmployeeMaster();
	emp.setEmpId(empId);
	model.addAttribute("employee", emp);
	return new ModelAndView("admin/employeeMaster");
}
@RequestMapping("locationMas")
public ModelAndView locationMaster(ModelMap model)
{
	String locationId=adminServices.generateLocationId();
	LocationMaster locationMas=new LocationMaster();
	locationMas.setLocationId(locationId);
	model.addAttribute("locationMast", locationMas);
	return new ModelAndView("admin/locationMaster");
}

@RequestMapping("locationMaster")
public String locationMaster(@ModelAttribute LocationMaster location,ModelMap model)
{
	if(adminServices.locationSave(location))
		model.addAttribute("success","Location added Successfully with Id " +location.getLocationId());
	else
		model.addAttribute("error","Location not added with Id " +location.getLocationId());
	
	String locationId=adminServices.generateLocationId();
	LocationMaster locationMas=new LocationMaster();
	locationMas.setLocationId(locationId);
	model.addAttribute("locationMast", locationMas);
	return "admin/locationMaster";
}
@RequestMapping("getLocation")
public ModelAndView getLocation()
{
	
	return new ModelAndView("admin/locationShow","locationList",adminServices.getLocationList());
	
}
@RequestMapping("editLocation")
public String editLocation(@RequestParam String locationId,ModelMap model)
{
	LocationMaster loc= adminServices.locationEdit(locationId);
	model.addAttribute("location",loc);
	
	return "admin/locationEdit";
}
@RequestMapping("deleteLocation")
public ModelAndView deleteLocation(@RequestParam String locationId,ModelMap model)
{
	if(adminServices.deleteLocation(locationId))
	{
		model.addAttribute("msg","Record deleted successfully "+locationId);
	}
	else{
		model.addAttribute("msg","Record not deleted successfully "+locationId);
	}
	return new ModelAndView("admin/locationShow","locationList",adminServices.getLocationList());
	
}
@RequestMapping("modelMas")
public ModelAndView modelMaster(ModelMap model)
{
	String modelId=adminServices.generateModelId();
	ModelMaster modelMas=new ModelMaster();
	modelMas.setModelId(modelId);
	model.addAttribute("modelMast", modelMas);
	return new ModelAndView("admin/modelMaster");
}
@RequestMapping("modelAdd")
public String modelMaster(@ModelAttribute ModelMaster modelMast,ModelMap model)
{
	if(adminServices.modelSave(modelMast))
		model.addAttribute("success","Model added Successfully with Id " +modelMast.getModelId());
	else
		model.addAttribute("error","Customer not added with Id " +modelMast.getModelId());
	
	String modelId=adminServices.generateModelId();
	ModelMaster modelMas=new ModelMaster();
	modelMas.setModelId(modelId);
	model.addAttribute("modelMast", modelMas);
	return "admin/modelMaster" ;
}
@RequestMapping("getModel")
public ModelAndView viewModel()
{
	
	return new ModelAndView("admin/modelShow","modelList",adminServices.getModelList());
	
}
@RequestMapping("editModel")
public String editModel(@RequestParam String modelId,ModelMap model)
{
	ModelMaster mod= adminServices.modelEdit(modelId);
	model.addAttribute("model",mod);
	
	return "admin/modelEdit";
}
@RequestMapping("deleteModel")
public ModelAndView deleteModel(@RequestParam String modelId,ModelMap model)
{
	if(adminServices.deleteModel(modelId))
	{
		model.addAttribute("msg","Model deleted successfully "+modelId);
	}
	else{
		model.addAttribute("msg","Model not deleted successfully "+modelId);
	}
	return new ModelAndView("admin/modelShow","modelList",adminServices.getModelList());
	
}
@RequestMapping("unitMaster")
public String unitMaster(@ModelAttribute UnitMaster unit,ModelMap model)
{
	
	if(adminServices.unitSave(unit))
	
		model.addAttribute("success","Unit added Successfully with Id " +unit.getUnitId());
		
	else
		model.addAttribute("error","Unit not added with Id " +unit.getUnitId());
	
	String unitId=adminServices.generateUnitId();
	UnitMaster unitMas=new UnitMaster();
	unitMas.setUnitId(unitId);
	model.addAttribute("unitMas", unitMas);
	return "admin/unitMaster" ;
}
@RequestMapping("getUnit")
public ModelAndView getUnit()
{
	return new ModelAndView("admin/unitShow","unitList",adminServices.getUnitList());
}
@RequestMapping("editUnit")
public String editUnit(@RequestParam String unitId,ModelMap model)
{
	UnitMaster unit= adminServices.unitEdit(unitId);
	model.addAttribute("unit",unit);
	
	return "admin/unitEdit";
}

@RequestMapping("deleteUnit")
public ModelAndView deleteUnit(@RequestParam String unitId,ModelMap model)
{
	if(adminServices.deleteUnit(unitId))
	{
		model.addAttribute("msg","Unit deleted successfully "+unitId);
	}
	else{
		model.addAttribute("msg","Unit not deleted successfully "+unitId);
	}
	return new ModelAndView("admin/unitShow","unitList",adminServices.getUnitList());
	
}
@RequestMapping("unitMas")
public ModelAndView unitMaster(ModelMap model)
{
	String unitId=adminServices.generateUnitId();
	UnitMaster unitMas=new UnitMaster();
	unitMas.setUnitId(unitId);
	model.addAttribute("unitMas", unitMas);
	
	return new ModelAndView("admin/unitMaster");
}
@RequestMapping("productMas")
public ModelAndView productMaster(ModelMap model)
{
	
	String productId=adminServices.generateProductId();
	ProductMaster productMas=new ProductMaster();
	productMas.setProductId(productId);
	List<ModelMaster> modelDetails=adminServices.generateModelDetails();
	model.addAttribute("modelList", modelDetails);
	model.addAttribute("productMast", productMas);
	return new ModelAndView("admin/productMaster") ;
}
@RequestMapping("productAdd")
public String productMaster(@ModelAttribute ProductMaster product,ModelMap model)
{
	
	if(adminServices.productSave(product))
	
		model.addAttribute("success","Product added Successfully with Id " +product.getProductId());
		
	else
		model.addAttribute("error","Product not added with Id " +product.getProductId());
	
	String productId=adminServices.generateProductId();
	ProductMaster productMas=new ProductMaster();
	productMas.setProductId(productId);
	List<ModelMaster> modelDetails=adminServices.generateModelDetails();
	model.addAttribute("modelList", modelDetails);
	model.addAttribute("productMast", productMas);
	return "admin/productMaster" ;
}
@RequestMapping("getProduct")
public ModelAndView viewProduct()
{
	return new ModelAndView("admin/productShow","productList",adminServices.getProductList());
}
@RequestMapping("editProduct")
public String editProduct(@RequestParam String productId,ModelMap model)
{
	ProductMaster product= adminServices.productEdit(productId);
	model.addAttribute("product",product);
	List<ModelMaster> modelDetails=adminServices.generateModelDetails();
	model.addAttribute("modelList", modelDetails);
	return "admin/productEdit";
}

@RequestMapping("deleteProduct")
public ModelAndView deleteProduct(@RequestParam String productId,ModelMap model)
{
	if(adminServices.deleteProduct(productId))
	{
		model.addAttribute("msg","Model deleted successfully "+productId);
	}
	else{
		model.addAttribute("msg","Model not deleted successfully "+productId);
	}
	return new ModelAndView("admin/productShow","productList",adminServices.getProductList());
	
}
@RequestMapping("spareMas")
public ModelAndView spareMaster(ModelMap model)
{
	String spareId=adminServices.generateSpareId();
	SpareMaster spa=new SpareMaster();
	spa.setSpareId(spareId);
	model.addAttribute("spare", spa);
	
	return new ModelAndView("admin/spareMaster");
}
@RequestMapping("getSpare")
public ModelAndView getSpare()
{
	return new ModelAndView("admin/spareShow","spareList",adminServices.getSpareList());
}
@RequestMapping("editSpare")
public String editSpare(@RequestParam String spareId,ModelMap model)
{
	SpareMaster spare= adminServices.spareEdit(spareId);
	model.addAttribute("spare",spare);
	
	return "admin/spareEdit";
}

@RequestMapping("deleteSpare")
public ModelAndView deleteSpare(@RequestParam String spareId,ModelMap model)
{
	if(adminServices.deleteSpare(spareId))
	{
		model.addAttribute("msg","Spare deleted successfully "+spareId);
	}
	else{
		model.addAttribute("msg","Spare not deleted successfully "+spareId);
	}
	return new ModelAndView("admin/spareShow","spareList",adminServices.getSpareList());
	
}
@RequestMapping("deleteCustomer")
public ModelAndView deleteCustomer(@RequestParam String customerId,ModelMap model)
{
	if(adminServices.deleteCustomer(customerId))
	{
		model.addAttribute("msg","Record deleted successfully "+customerId);
	}
	else{
		model.addAttribute("msg","Record not deleted successfully "+customerId);
	}
	return new ModelAndView("admin/customerShow","customerList",adminServices.getCustomerList());
	
}
@RequestMapping("employeeRegstration")
public String employeeRegstration(@ModelAttribute EmployeeMaster employee,ModelMap model)
{
	if(adminServices.EmployeeSave(employee))
		model.addAttribute("success","Employee added Successfully with Id"+employee.getEmpId());
	else
		model.addAttribute("error","Employee not added with Id"+employee.getEmpId());
	String empId=adminServices.generateEmployeeId();
	EmployeeMaster emp=new EmployeeMaster();
	emp.setEmpId(empId);
	model.addAttribute("employee", emp);
	return "admin/employeeMaster" ;
}
@RequestMapping("getEmployee")
public ModelAndView viewEmployee()
{
	return new ModelAndView("admin/employeeShow","employeeList",adminServices.getEmployeeList());
}

@RequestMapping("editEmployee")
public String editEmployee(@RequestParam String empId,ModelMap model)
{
	EmployeeMaster emp= adminServices.employeeEdit(empId);
	model.addAttribute("emp",emp);
	
	return "admin/employeeEdit";
}
@RequestMapping("deleteEmployee")
public ModelAndView deleteEmployee(@RequestParam String empId,ModelMap model)
{
	if(adminServices.deleteEmployee(empId))
	{
		model.addAttribute("msg","Record deleted successfully "+empId);
	}
	else{
		model.addAttribute("msg","Record not deleted successfully "+empId);
	}
	return new ModelAndView("admin/employeeShow","employeeList",adminServices.getEmployeeList());
	
}
@RequestMapping("warrantyTrack")
public ModelAndView warrantyTrack(ModelMap model)
{
	String docId=adminServices.generateDocId();
	WarrantyTracking doc=new WarrantyTracking();
	doc.setDocId(docId);
	model.addAttribute("warranty", doc);
	List<CustomerMaster> customerDetails=adminServices.generateCustomerDetails();
	model.addAttribute("customerList", customerDetails);
	List<ProductMaster> productDetails=adminServices.generateProductDetails();
	model.addAttribute("productList", productDetails);
	return new ModelAndView("admin/warrantyTracking");
}
@RequestMapping("warrantyAdd")
public String warrantyAdd(@ModelAttribute WarrantyTracking warranty,ModelMap model)
{
	if(adminServices.warrantySave(warranty))
		model.addAttribute("success","Warranty added Successfully with Id "+warranty.getDocId());
	else
		model.addAttribute("error","Warranty not added with Id "+warranty.getDocId());
	String docId=adminServices.generateDocId();
	WarrantyTracking doc=new WarrantyTracking();
	doc.setDocId(docId);
	model.addAttribute("warranty", doc);
	List<CustomerMaster> customerDetails=adminServices.generateCustomerDetails();
	model.addAttribute("customerList", customerDetails);
	List<ProductMaster> productDetails=adminServices.generateProductDetails();
	model.addAttribute("productList", productDetails);
	return "admin/warrantyTracking" ;
}

@RequestMapping("getWarranty")
public ModelAndView getWarranty()
{
	return new ModelAndView("admin/warrantyTrackingShow","warranty",adminServices.getWarrantyList());
}

@RequestMapping("editWarranty")
public String editWarranty(@RequestParam String docId,ModelMap model)
{
	WarrantyTracking warr= adminServices.warrantyEdit(docId);
	model.addAttribute("warranty",warr);
	List<CustomerMaster> customerDetails=adminServices.generateCustomerDetails();
	model.addAttribute("customerList", customerDetails);
	List<ProductMaster> productDetails=adminServices.generateProductDetails();
	model.addAttribute("productList", productDetails);
	return "admin/warrantyTrackingEdit";
}

@RequestMapping("deleteWarranty")
public ModelAndView deleteWarranty(@RequestParam String docId,ModelMap model)
{
	if(adminServices.deleteWarranty(docId))
	{
		model.addAttribute("msg","Warranty  deleted successfully "+docId);
	}
	else{
		model.addAttribute("msg","Warranty not deleted successfully "+docId);
	}
	return new ModelAndView("admin/warrantyTrackingShow","warranty",adminServices.getWarrantyList());
	
}
@RequestMapping(value="ajaxtest",produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody CustomerMaster ajaxTest(@RequestParam String customerId)
{
	return adminServices.getCustomerAddress(customerId);
}
@RequestMapping("spareAdd")
public String spareAdd(@ModelAttribute SpareMaster spare,ModelMap model)
{
	if(adminServices.addSpare(spare))
		model.addAttribute("success","Spare added Successfully with Id"+spare.getSpareId());
	else
		model.addAttribute("error","Spare not added with Id"+spare.getSpareId());
	String spareId=adminServices.generateSpareId();
	SpareMaster spa=new SpareMaster();
	spa.setSpareId(spareId);
	model.addAttribute("spare", spa);
	return ("admin/spareMaster");
}

@RequestMapping(value="validCstUserName",produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody boolean validCstUserName(@RequestParam String userName)
{
	return adminServices.getCstUserName(userName);
}
}