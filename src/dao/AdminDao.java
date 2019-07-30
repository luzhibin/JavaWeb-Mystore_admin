package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.Admin;
import utils.JDBCUtil;

public class AdminDao {

	public Admin checkAdmin(String name, String pwd) throws SQLException{
		//到数据库中查询
		//1.连接数据库
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		//2.查询数据
		String sql = "select * from admin where username=? and password=?";
		System.out.println(sql);
		//3.执行查询语句
		//BeanHandler: 把结果集转为一个 Bean,并返回.。Bean的类型在创建BeanHandler 对象时以 Class 对象的方式传入 BeanHandler(Class<T> type)。
		Admin admin = null;
		admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),name,pwd);
		System.out.println(admin); 
		return admin;//返回的Admin类型与domain类里的Admin对应
	}

}
