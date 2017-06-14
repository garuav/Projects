package sla.services;

import java.util.List;


import sla.bean.CustomerMaster;
import sla.bean.EmployeeMaster;
import sla.bean.LocationMaster;
import sla.bean.ModelMaster;
import sla.bean.ProductMaster;
import sla.bean.SpareMaster;
import sla.bean.UnitMaster;
import sla.bean.WarrantyTracking;

public interface AdminServices {
	public boolean CustomerSave(CustomerMaster customer);
	public List<CustomerMaster> getCustomerList();
	public CustomerMaster getCustomerEdit(String customerId);
	public String generateCustomerId();
	public boolean deleteCustomer(String customerId);
	public boolean EmployeeSave(EmployeeMaster employee);
	public String generateEmployeeId();
	public List<EmployeeMaster> getEmployeeList();
	public EmployeeMaster employeeEdit(String empId);
	public boolean deleteEmployee(String empId);
	public boolean modelSave(ModelMaster modelMas);
	public String generateModelId();
	public List<ModelMaster> generateModelDetails();
	public List<ModelMaster> getModelList();
	public ModelMaster modelEdit(String modelId);
	public boolean deleteModel(String modelId);
	public boolean productSave(ProductMaster product);
	public String generateProductId();
	public List<ProductMaster> getProductList();
	public boolean deleteProduct(String productId);
	public List<CustomerMaster> generateCustomerDetails();
	public CustomerMaster getCustomerAddress(String customerId);
	public List<ProductMaster> generateProductDetails();
	public ProductMaster productEdit(String productId);
	public boolean addSpare(SpareMaster spare);
	public List<SpareMaster> getSpareList();
	public SpareMaster spareEdit(String spareId);
	public boolean deleteSpare(String spareId);
	public String generateSpareId();
	public boolean locationSave(LocationMaster locationMas);
	public String generateLocationId();
	public List<LocationMaster> getLocationList();
	public LocationMaster locationEdit(String locationId);
	public boolean deleteLocation(String locationId);
	public boolean unitSave(UnitMaster unitMas);
	public String generateUnitId();
	public List<UnitMaster> getUnitList();
	public UnitMaster unitEdit(String unitId);
	public boolean deleteUnit(String unitId);
	public boolean getCstUserName(String userName);
	public boolean warrantySave(WarrantyTracking warranty);
	public List<WarrantyTracking> getWarrantyList();
	public String generateDocId();
	public WarrantyTracking warrantyEdit(String docId);
	public boolean deleteWarranty(String docId);
}
