package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Goods;
import utils.JDBCUtil;

public class GoodsDao {
	//1.从数据库中查询所有商品列表
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
	public List<Goods> getAllGoods() throws Exception{
		//查询操作
		String sql = "select * from goods";
		//执行sql
		List<Goods> allGoods = null;
		allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		return allGoods;
	}
	
	//2.添加商品到数据库中
	public void addGoods(Goods goods) throws SQLException {
		//插入操作
		String sql = "insert into goods(name,price,image,gdesc,is_hot,cid) value (?,?,?,?,?,?)";
		qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getGdesc(),goods.getIs_hot(),goods.getCid());
	}
	//3.根据ID从数据库中删除一个商品
	public void delGoods(int id) throws SQLException {
		//删除操作
		String sql = "DELETE FROM goods WHERE id=?";
		qr.update(sql,id);
		
	}
	//4.传入一个商品，到数据库中根据id更新该商品
	public void updateGoods(Goods goods) throws SQLException {
		String sql = "update goods set name=?,price=?,image=?,gdesc=?,is_hot=?,cid=? where id=?";
		qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getGdesc(),goods.getIs_hot(),goods.getCid(),goods.getId());
	}

	public Goods getGoodsWithID(String id) throws Exception{
		String sql = "select * from goods where id=?";
		Goods goods = qr.query(sql,new BeanHandler<Goods>(Goods.class),Integer.parseInt(id));
		return goods;
	}
}
