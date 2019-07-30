package service;

import dao.AdminDao;
import domain.Admin;

public class AdminService {

	public Admin login(String name, String pwd) throws Exception {
		//调用dao层到数据库中查询
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.checkAdmin(name,pwd);
		//判断用户是否有值，有值的话返回admin
		System.out.println("AdminService");
		if(admin != null) {
			return admin;
		}else {
			throw new Exception("用户名或密码错误");
		}
	}

}
