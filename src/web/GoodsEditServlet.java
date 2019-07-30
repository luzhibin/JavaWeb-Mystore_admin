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

/**
 * Servlet implementation class GoodsEditServlet
 */
@WebServlet("/GoodsEditServlet")
public class GoodsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GoodsEditServlet");
		
		request.setCharacterEncoding("utf-8");
		//1.��ȡ���в���
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		//2.��װ��goods����
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_016.png");
			//3.����id��������
			//4.���÷���㣬��������
			GoodsService goodsService = new GoodsService();
			goodsService.updateGoods(goods);
			//System.out.println(goods);
			//��ת��GoodsListServlet��Ȼ��ת����main.jsp
			request.getRequestDispatcher("/GoodsListServlet").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
