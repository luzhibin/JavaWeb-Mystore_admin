package test;

import java.util.List;

import org.junit.Test;

import dao.GoodsDao;
import domain.Goods;



public class GoodsDaoTest {
	private GoodsDao goodsDao = new GoodsDao();
	@Test
	public void testGetAllGoods() throws Exception {
		List<Goods> allGoods = goodsDao.getAllGoods();
		System.out.println(allGoods);
	}
	@Test
	public void testAddGoods() throws Exception {
		Goods goods = new Goods();
		goods.setName("Nike Air Mag回到未来");
		goods.setPrice(79999.0);
		goods.setImage("goods_10.png");
		goodsDao.addGoods(goods);
	}
	@Test
	public void testDelGoods() throws Exception {
		goodsDao.delGoods(18);
	}
	@Test
	public void testUpdateGoods() throws Exception {
		Goods goods = new Goods();
		goods.setId(18);
		goods.setName("Nike Air Mag回到未来");
		goods.setPrice(79999.0);
		goods.setImage("goods_10.png");
		goodsDao.updateGoods(goods);
	}
}
