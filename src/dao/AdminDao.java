package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.Admin;
import utils.JDBCUtil;

public class AdminDao {

	public Admin checkAdmin(String name, String pwd) throws SQLException{
		//�����ݿ��в�ѯ
		//1.�������ݿ�
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		//2.��ѯ����
		String sql = "select * from admin where username=? and password=?";
		System.out.println(sql);
		//3.ִ�в�ѯ���
		//BeanHandler: �ѽ����תΪһ�� Bean,������.��Bean�������ڴ���BeanHandler ����ʱ�� Class ����ķ�ʽ���� BeanHandler(Class<T> type)��
		Admin admin = null;
		admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),name,pwd);
		System.out.println(admin); 
		return admin;//���ص�Admin������domain�����Admin��Ӧ
	}

}
