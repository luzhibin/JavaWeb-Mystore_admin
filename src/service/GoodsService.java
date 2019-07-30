package service;

import java.util.List;

import dao.GoodsDao;
import domain.Goods;

public class GoodsService {
	private GoodsDao goodsDao = new GoodsDao();
	public List<Goods> getAllGoods() throws Exception {
		//����Dao������ݿ��л�ȡ������Ʒ����
		List<Goods> allGoods = goodsDao.getAllGoods();
		return allGoods;
	}
	//ɾ����Ʒ
	public void deleteGoods(String id) throws Exception, Exception {
		//����DAOɾ����Ʒ
		goodsDao.delGoods(Integer.parseInt(id));
	}
	public void addGoods(Goods goods) throws Exception {
		//����DAO�� �������
		goodsDao.addGoods(goods);
	}
	public Goods getGoodsWithID(String id) throws Exception {
		//����DAO�㣬 ��ѯһ����Ʒ������id����
		Goods goods = goodsDao.getGoodsWithID(id);
		return goods;
	}
	public void updateGoods(Goods goods) throws Exception {
		goodsDao.updateGoods(goods);
	}


	
}
