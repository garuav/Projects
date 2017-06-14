package sla.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;


@Entity
@Table(name="spareRequire")
public class SpareRequire {
	@Id
	private String requireId;
	private String requireEntryDate;
	private String engName;
	@SuppressWarnings("unchecked")
	@OneToMany(mappedBy = "require", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<AddSpare> spr=LazyList.decorate(new ArrayList<AddSpare>(),FactoryUtils.instantiateFactory(AddSpare.class));
	
	public String getRequireId() {
		return requireId;
	}
	public void setRequireId(String requireId) {
		this.requireId = requireId;
	}
	public String getRequireEntryDate() {
		return requireEntryDate;
	}
	public void setRequireEntryDate(String requireEntryDate) {
		this.requireEntryDate = requireEntryDate;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public List<AddSpare> getSpr() {
		return spr;
	}
	public void setSpr(List<AddSpare> spr) {
		this.spr = spr;
	}

}
