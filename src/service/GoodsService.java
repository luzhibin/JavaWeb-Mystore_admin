package service;

import java.util.List;

import dao.GoodsDao;
import domain.Goods;

public class GoodsService {
	private GoodsDao goodsDao = new GoodsDao();
	public List<Goods> getAllGoods() throws Exception {
		//调用Dao层从数据库中获取所有商品数据
		List<Goods> allGoods = goodsDao.getAllGoods();
		return allGoods;
	}
	//删除商品
	public void deleteGoods(String id) throws Exception, Exception {
		//调用DAO删除商品
		goodsDao.delGoods(Integer.parseInt(id));
	}
	public void addGoods(Goods goods) throws Exception {
		//调用DAO层 插入操作
		goodsDao.addGoods(goods);
	}
	public Goods getGoodsWithID(String id) throws Exception {
		//调用DAO层， 查询一个商品，根据id操作
		Goods goods = goodsDao.getGoodsWithID(id);
		return goods;
	}
	public void updateGoods(Goods goods) throws Exception {
		goodsDao.updateGoods(goods);
	}


	
}
