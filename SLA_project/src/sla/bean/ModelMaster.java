package sla.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modelmaster")
public class ModelMaster {
	@Id
	private String modelId;
	private String modelName;
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
