package sla.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="spareMaster")
public class SpareMaster {
	@Id
private String spareId;
private String spareName;
private String rate;
private String unit;
public String getSpareId() {
	return spareId;
}
public void setSpareId(String spareId) {
	this.spareId = spareId;
}
public String getSpareName() {
	return spareName;
}
public void setSpareName(String spareName) {
	this.spareName = spareName;
}
public String getRate() {
	return rate;
}
public void setRate(String rate) {
	this.rate = rate;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
}
