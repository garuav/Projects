package sla.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="addSpare")

public class AddSpare implements Serializable{
	@Id
	private int srNo;
	private String nameSpare;
	private String quantitySpare;
	private String requireDateSpare;
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="requireId")
	private SpareRequire require;
	
	public SpareRequire getRequire() {
		return require;
	}
	public void setRequire(SpareRequire require) {
		this.require = require;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getNameSpare() {
		return nameSpare;
	}
	public void setNameSpare(String nameSpare) {
		this.nameSpare = nameSpare;
	}
	public String getQuantitySpare() {
		return quantitySpare;
	}
	public void setQuantitySpare(String quantitySpare) {
		this.quantitySpare = quantitySpare;
	}
	public String getRequireDateSpare() {
		return requireDateSpare;
	}
	public void setRequireDateSpare(String requireDateSpare) {
		this.requireDateSpare = requireDateSpare;
	}
	

}
@Embeddable
class AddKey {
   	int srNo;
    String requireId ;
}