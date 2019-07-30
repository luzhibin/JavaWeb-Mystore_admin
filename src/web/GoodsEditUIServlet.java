package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import domain.Goods;
import service.CategoryService;
import service.GoodsService;

@WebServlet("/GoodsEditUIServlet")
public class GoodsEditUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取当前商品的id
		String id = request.getParameter("id");
		System.out.println("GoodsEditUIServlet=" + id);
		try {
			// 1.获取当前商品
			GoodsService goodsService = new GoodsService();
			Goods goods = goodsService.getGoodsWithID(id);
			
			// 把商品写到域中
			request.setAttribute("goods", goods);

			// 2.获取所有分类
			CategoryService categoryService = new CategoryService();
			List<Category> allCategory = categoryService.findCategory();
			request.setAttribute("allCategory", allCategory);
			
			// 转发到edit.jsp
			request.getRequestDispatcher("/admin/edit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
