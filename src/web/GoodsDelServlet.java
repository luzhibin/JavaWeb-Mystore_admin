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
		//1.���ղ���id
		String id = request.getParameter("id");//����id��Դ��a��ǩ��ġ�?id=${goods.id}��<a>��ǩʹ��"?"����
		//2.��������㣬����ɾ����Ʒ
		GoodsService goodsService = new GoodsService();	
		try {
			goodsService.deleteGoods(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ת��
		request.getRequestDispatcher("/GoodsListServlet").forward(request, response);
		}
		
}
