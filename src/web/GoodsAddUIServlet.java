package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import service.CategoryService;


@WebServlet("/GoodsAddUIServlet")
public class GoodsAddUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//添加商品UI界面的Servlet
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GoodsAddUIServlet");
		//1.取出所有的分类
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findCategory();
			//2.把分类存到域中
			request.setAttribute("allCategory", allCategory);
			System.out.println("allCategory:"+allCategory);
			//3.转发到add.jsp
			request.getRequestDispatcher("/admin/add.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
