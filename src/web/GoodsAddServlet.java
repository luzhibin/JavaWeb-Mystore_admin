package web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Goods;
import service.GoodsService;


@WebServlet("/GoodsAddServlet")
public class GoodsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GoodsAddServlet");
		//处理乱码问题
		request.setCharacterEncoding("utf-8");
		//获取所有参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		//把参数封装成对象  导入beanutils-jar包
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_016.png");
			System.out.println(goods);
			//调用服务层
			GoodsService goodsService = new GoodsService(); 
			goodsService.addGoods(goods);
			//跳转到GoodsListServlet,从数据库获取最新的列表数据，然后转发到main.jsp
			request.getRequestDispatcher("/GoodsListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
