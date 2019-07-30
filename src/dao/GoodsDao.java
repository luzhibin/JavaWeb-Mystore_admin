package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Goods;
import utils.JDBCUtil;

public class GoodsDao {
	//1.�����ݿ��в�ѯ������Ʒ�б�
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
	public List<Goods> getAllGoods() throws Exception{
		//��ѯ����
		String sql = "select * from goods";
		//ִ��sql
		List<Goods> allGoods = null;
		allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		return allGoods;
	}
	
	//2.�����Ʒ�����ݿ���
	public void addGoods(Goods goods) throws SQLException {
		//�������
		String sql = "insert into goods(name,price,image,gdesc,is_hot,cid) value (?,?,?,?,?,?)";
		qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getGdesc(),goods.getIs_hot(),goods.getCid());
	}
	//3.����ID�����ݿ���ɾ��һ����Ʒ
	public void delGoods(int id) throws SQLException {
		//ɾ������
		String sql = "DELETE FROM goods WHERE id=?";
		qr.update(sql,id);
		
	}
	//4.����һ����Ʒ�������ݿ��и���id���¸���Ʒ
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
