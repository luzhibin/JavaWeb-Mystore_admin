package service;

import java.util.List;

import dao.CategoryDao;
import domain.Category;

public class CategoryService {

	//获取所有的分类信息
	public List<Category> findCategory() throws Exception {
		//从数据库中查找
		CategoryDao categoryDao = new CategoryDao();
		List<Category> allCategory = categoryDao.getAllCategory();
		return allCategory;
	}

}
