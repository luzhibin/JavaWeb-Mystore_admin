package service;

import dao.AdminDao;
import domain.Admin;

public class AdminService {

	public Admin login(String name, String pwd) throws Exception {
		//����dao�㵽���ݿ��в�ѯ
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.checkAdmin(name,pwd);
		//�ж��û��Ƿ���ֵ����ֵ�Ļ�����admin
		System.out.println("AdminService");
		if(admin != null) {
			return admin;
		}else {
			throw new Exception("�û������������");
		}
	}

}
