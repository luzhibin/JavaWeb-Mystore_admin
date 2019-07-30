package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Category;
import utils.JDBCUtil;

public class CategoryDao {
	
	//获取所有分类信息
	public List<Category> getAllCategory() throws Exception {
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from category";
		List<Category> allCategory = null;
		allCategory = qr.query(sql,new BeanListHandler<Category>(Category.class));
		return allCategory;
	}

}
