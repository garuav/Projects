package sla.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sla.bean.Login;
import sla.dao.LoginDaoImpl;
@Component("loginImpl")
public class LoginServiceImpl implements LoginService {

	private LoginDaoImpl loginDao;
	public LoginDaoImpl getLoginDao() {
		return loginDao;
	}
	@Autowired
	public void setLoginDao(LoginDaoImpl loginDao) {
		this.loginDao = loginDao;
	}
	@Override
	public String validLogin(Login l) {
		return loginDao.validLoginDao(l);
//		System.out.println("id = "+l.getUserId());
//		if(l.getUserId().equals("admin") && l.getPassword().equals("admin123"))
//			return ("admin");
//		else if(l.getUserId().equals("customer" )&& l.getPassword().equals("customer123"))
//			return ("customer");
//		else if(l.getUserId().equals("telecaller") && l.getPassword().equals("telecaller123"))
//			return("telecaller");
//		else if(l.getUserId().equals("engineer") && l.getPassword().equals("engineer123"))
//			return("engineer");
//		else if(l.getUserId().equals("manager" )&& l.getPassword().equals("manager123"))
//			return("manager");
//		else
//			return "error login";
	}

	
	
}
