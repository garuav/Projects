package sla.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name="login")
public class Login {
	@Id
	private String userId;
	private String password;
	private String logInType;
	private String logId;
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogInType() {
		return logInType;
	}
	public void setLogInType(String logInType) {
		this.logInType = logInType;
	}

}
