package service;

import java.util.List;

import dao.CategoryDao;
import domain.Category;

public class CategoryService {

	//��ȡ���еķ�����Ϣ
	public List<Category> findCategory() throws Exception {
		//�����ݿ��в���
		CategoryDao categoryDao = new CategoryDao();
		List<Category> allCategory = categoryDao.getAllCategory();
		return allCategory;
	}

}
