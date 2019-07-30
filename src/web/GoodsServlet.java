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
	// ��ȡ������Ʒ
	public String getListGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("��ѯ������Ʒ");
		// ���÷����
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.getAllGoods();
			// ���Ϸ�ת
			java.util.Collections.reverse(allGoods);
			System.out.println(allGoods);
			// ������д��request����
			request.setAttribute("allGoods", allGoods);
			return "admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String delGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����idɾ��ָ����Ʒ");
		//1.���ղ���id
		String id = request.getParameter("id");//����id��Դ��a��ǩ��ġ�?id=${goods.id}��<a>��ǩʹ��"?"����
		//2.��������㣬����ɾ����Ʒ
		GoodsService goodsService = new GoodsService();	
		try {
			goodsService.deleteGoods(id);
			//ת��
			return "/GoodsServlet?action=getListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	}
