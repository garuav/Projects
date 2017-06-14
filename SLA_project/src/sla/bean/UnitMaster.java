package sla.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unitMaster")
public class UnitMaster {
	@Id
	private String unitId;
	private String symbol;
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
