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

	//�����ƷUI�����Servlet
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GoodsAddUIServlet");
		//1.ȡ�����еķ���
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findCategory();
			//2.�ѷ���浽����
			request.setAttribute("allCategory", allCategory);
			System.out.println("allCategory:"+allCategory);
			//3.ת����add.jsp
			request.getRequestDispatcher("/admin/add.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
