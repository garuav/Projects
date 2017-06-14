package sla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sla.bean.CustomerMaster;
import sla.bean.EmployeeMaster;
import sla.bean.LocationMaster;
import sla.bean.ModelMaster;
import sla.bean.ProductMaster;
import sla.bean.SpareMaster;
import sla.bean.UnitMaster;
import sla.bean.WarrantyTracking;
import sla.dao.AdminDaoImplementation;

@Component("adminServices")
public class AdminServicesImplementation implements AdminServices{
	private AdminDaoImplementation adminDao;
	

	public AdminDaoImplementation getAdminDao() {
		return adminDao;
	}
@Autowired
	public void setAdminDao(AdminDaoImplementation adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean CustomerSave(CustomerMaster customer) {
		
		return adminDao.CustomerSaveDao(customer);
	}

	@Override
	public List<CustomerMaster> getCustomerList() {
		
		return adminDao.getCustomerListDao();
	}
	@Override
	public CustomerMaster getCustomerEdit(String customerId) {
		return adminDao.getCustomerEditDao(customerId);
	}
	@Override
	public String generateCustomerId() {
		
		return adminDao.generateCustomerId();
	}
	public boolean deleteCustomer(String customerId) {
		
		return adminDao.deleteCustomer(customerId);
	}
	@Override
	public boolean EmployeeSave(EmployeeMaster employee) {
		return adminDao.EmployeeSaveDao(employee);
	}
	@Override
	public String generateEmployeeId() {
		return adminDao.generateEmployeeId();
	}
	@Override
	public List<EmployeeMaster> getEmployeeList() {
		return adminDao.getEmployeeListDao();
	}
	@Override
	public boolean modelSave(ModelMaster modelMas) {
		return adminDao.modelSaveDao(modelMas);
	}
	@Override
	public String generateModelId() {
		return adminDao.generateModelId();
	}
	@Override
	public List<ModelMaster> getModelList() {
		return adminDao.getModelListDao();
	}
	@Override
	public boolean productSave(ProductMaster product) {
		return adminDao.productSaveDao(product);
	}
	@Override
	public String generateProductId() {
		return adminDao.generateProductId();
	}
	@Override
	public List<ProductMaster> getProductList() {
		return adminDao.getProductListDao();
	}
	@Override
	public List<CustomerMaster> generateCustomerDetails() {
		
		return adminDao.generateCustomerDetailsDao();
	}
	@Override
	public CustomerMaster getCustomerAddress(String customerId) {
		
		return adminDao.getCustomerAddressDao(customerId);
	}
	@Override
	public List<ProductMaster> generateProductDetails() {
		
		return adminDao.generateProductDetailsDao();
	}
	@Override
	public boolean addSpare(SpareMaster spare) {
		return adminDao.spareSaveDao(spare);
	}
	@Override
	public String generateSpareId() {
		return adminDao.generateSpareId();
	}
	@Override
	public List<ModelMaster> generateModelDetails() {
		
		return adminDao.generateModelDetailsDao();
	}
	@Override
	public ProductMaster productEdit(String productId) {
		
		return adminDao.productEditDao(productId);
	}
	@Override
	public EmployeeMaster employeeEdit(String empId) {
		
		return adminDao.employeeEditDao(empId);
	}
	@Override
	public boolean deleteEmployee(String empId) {
		
		return adminDao.deleteEmployeeDao(empId);
	}
	@Override
	public boolean locationSave(LocationMaster locationMas) {
		
		return adminDao.locationSaveDao(locationMas);
	}
	@Override
	public String generateLocationId() {
		
		return adminDao.generateLocationIdDao();
	}
	@Override
	public List<LocationMaster> getLocationList() {
		
		return adminDao.getLocationListDao();
	}
	@Override
	public LocationMaster locationEdit(String locationId) {
		
		return adminDao.locationEditDao(locationId);
	}
	@Override
	public boolean deleteLocation(String locationId) {
		
		return adminDao.deleteLocation(locationId);
	}
	@Override
	public ModelMaster modelEdit(String modelId) {
		
		return adminDao.modelEditDao(modelId);
	}
	@Override
	public boolean deleteModel(String modelId) {
		
		return adminDao.deleteModel(modelId);
	}
	@Override
	public boolean deleteProduct(String productId) {
		
		return adminDao.deleteProduct(productId);
	}
	@Override
	public boolean unitSave(UnitMaster unitMas) {
		
		return adminDao.unitSaveDao(unitMas);
	}
	@Override
	public String generateUnitId() {
		
		return adminDao.generateUnitId();
	}
	@Override
	public List<UnitMaster> getUnitList() {
	
		return adminDao.getUnitListDao();
	}
	@Override
	public UnitMaster unitEdit(String unitId) {
		
		return adminDao.unitEditDao(unitId);
	}
	@Override
	public boolean deleteUnit(String unitId) {
		
		return adminDao.deleteUnit(unitId);
	}
	@Override
	public List<SpareMaster> getSpareList() {
		return adminDao.getSpareListDao();
	}
	@Override
	public SpareMaster spareEdit(String spareId) {
		
		return adminDao.spareEditDao(spareId);
	}
	@Override
	public boolean deleteSpare(String spareId) {
		
		return adminDao.deleteSpare(spareId);
	}
	@Override
	public boolean getCstUserName(String userName) {
		
		return adminDao.getCstUserName(userName);
	}
	@Override
	public boolean warrantySave(WarrantyTracking warranty) {
		
		return adminDao.warrantySaveDao(warranty);
	}
	@Override
	public String generateDocId() {
		
		return adminDao.generateDocId();
	}
	@Override
	public List<WarrantyTracking> getWarrantyList() {
		
		return adminDao.getWarrantyListDao();
	}
	@Override
	public WarrantyTracking warrantyEdit(String docId) {
		
		return adminDao.warrantyEditDao(docId);
	}
	@Override
	public boolean deleteWarranty(String docId) {
	
		return adminDao.deleteWarranty(docId);
	}
	

}
