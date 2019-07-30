package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Category;
import utils.JDBCUtil;

public class CategoryDao {
	
	//��ȡ���з�����Ϣ
	public List<Category> getAllCategory() throws Exception {
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from category";
		List<Category> allCategory = null;
		allCategory = qr.query(sql,new BeanListHandler<Category>(Category.class));
		return allCategory;
	}

}
