package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;

/**
 * Servlet implementation class GoodsDelServlet
 */
@WebServlet("/GoodsDelServlet")
public class GoodsDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GoodsDelServlet");
		//1.接收参数id
		String id = request.getParameter("id");//参数id来源于a标签里的【?id=${goods.id}】<a>标签使用"?"传参
		//2.调动服务层，让其删除商品
		GoodsService goodsService = new GoodsService();	
		try {
			goodsService.deleteGoods(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//转发
		request.getRequestDispatcher("/GoodsListServlet").forward(request, response);
		}
		
}
