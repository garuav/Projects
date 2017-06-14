package sla.bean;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="customerMaster",
uniqueConstraints = @UniqueConstraint(columnNames = {"userName", "email","phoneNo","mobile","fax"}))

public class CustomerMaster {
	
@Id
private String customerId;
private String customerName;
private String houseNo;
private String society;
private String locality;
private String city;
private String state;
private String userName;
private String email;
private String password;
private String phoneNo;
private String mobile;
private String fax;
private String customerType;

public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
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
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getFax() {
	return fax;
}
public void setFax(String fax) {
	this.fax = fax;
}
public String getCustomerType() {
	return customerType;
}
public void setCustomerType(String customerType) {
	this.customerType = customerType;
}


}
