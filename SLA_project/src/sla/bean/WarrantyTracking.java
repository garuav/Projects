package sla.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warrantyTracking")
public class WarrantyTracking {
@Id
private String docId;
private String customer;
private String docDate;
private String houseNo;
private String society;
private String locality;
private String city;
private String state;
private String productName;
private String purchaseDate;
private String dispatchDate;
private String eqtSrNo;
private String mgrSrNo;
private String installDate;
private String newWarrenty;
private String grossExp;
private String expiryDate;
public String getDocId() {
	return docId;
}
public void setDocId(String docId) {
	this.docId = docId;
}
public String getCustomer() {
	return customer;
}
public void setCustomer(String customer) {
	this.customer = customer;
}
public String getDocDate() {
	return docDate;
}
public void setDocDate(String docDate) {
	this.docDate = docDate;
}
public String getHouseNo() {
	return houseNo;
}
public void setHouseNo(String houseNo) {
	this.houseNo = houseNo;
}
public String getSociety() {
	return society;
}
public void setSociety(String society) {
	this.society = society;
}
public String getLocality() {
	return locality;
}
public void setLocality(String locality) {
	this.locality = locality;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getproductName() {
	return productName;
}
public void setproductName(String productName) {
	this.productName = productName;
}
public String getPurchaseDate() {
	return purchaseDate;
}
public void setPurchaseDate(String purchaseDate) {
	this.purchaseDate = purchaseDate;
}

public String getDispatchDate() {
	return dispatchDate;
}
public void setDispatchDate(String dispatchDate) {
	this.dispatchDate = dispatchDate;
}
public String getEqtSrNo() {
	return eqtSrNo;
}
public void setEqtSrNo(String eqtSrNo) {
	this.eqtSrNo = eqtSrNo;
}
public String getMgrSrNo() {
	return mgrSrNo;
}
public void setMgrSrNo(String mgrSrNo) {
	this.mgrSrNo = mgrSrNo;
}
public String getInstallDate() {
	return installDate;
}
public void setInstallDate(String installDate) {
	this.installDate = installDate;
}
public String getNewWarrenty() {
	return newWarrenty;
}
public void setNewWarrenty(String newWarrenty) {
	this.newWarrenty = newWarrenty;
}
public String getGrossExp() {
	return grossExp;
}
public void setGrossExp(String grossExp) {
	this.grossExp = grossExp;
}
public String getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(String expiryDate) {
	this.expiryDate = expiryDate;
}


}
