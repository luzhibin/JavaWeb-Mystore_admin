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
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GoodsListServlet");
		//���÷����
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.getAllGoods();
			//���Ϸ�ת
			java.util.Collections.reverse(allGoods);
			System.out.println(allGoods);
			//������д��request����
			request.setAttribute("allGoods",allGoods);
			request.getRequestDispatcher("admin/main.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
