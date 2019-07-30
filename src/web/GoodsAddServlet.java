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
		//������������
		request.setCharacterEncoding("utf-8");
		//��ȡ���в���
		Map<String, String[]> parameterMap = request.getParameterMap();
		//�Ѳ�����װ�ɶ���  ����beanutils-jar��
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_016.png");
			System.out.println(goods);
			//���÷����
			GoodsService goodsService = new GoodsService(); 
			goodsService.addGoods(goods);
			//��ת��GoodsListServlet,�����ݿ��ȡ���µ��б����ݣ�Ȼ��ת����main.jsp
			request.getRequestDispatcher("/GoodsListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
