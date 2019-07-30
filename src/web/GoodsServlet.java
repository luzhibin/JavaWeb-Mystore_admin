package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Goods;
import service.GoodsService;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
	// 获取所有商品
	public String getListGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("查询所有商品");
		// 调用服务层
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.getAllGoods();
			// 集合反转
			java.util.Collections.reverse(allGoods);
			System.out.println(allGoods);
			// 把数据写到request域中
			request.setAttribute("allGoods", allGoods);
			return "admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String delGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("根据id删除指定商品");
		//1.接收参数id
		String id = request.getParameter("id");//参数id来源于a标签里的【?id=${goods.id}】<a>标签使用"?"传参
		//2.调动服务层，让其删除商品
		GoodsService goodsService = new GoodsService();	
		try {
			goodsService.deleteGoods(id);
			//转发
			return "/GoodsServlet?action=getListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	}
