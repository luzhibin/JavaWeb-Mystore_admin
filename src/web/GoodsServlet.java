package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Category;
import domain.Goods;
import service.CategoryService;
import service.GoodsService;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ��ѯ��ȡ������Ʒ
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

	//ɾ����Ʒ
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
	
	//�����Ʒ��UI����
	public String addGoodsUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�����Ʒ����");
		//1.ȡ�����еķ���
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findCategory();
			//2.�ѷ���浽����
			request.setAttribute("allCategory", allCategory);
			System.out.println("allCategory:"+allCategory);
			//3.ת����add.jsp
			return "admin/add.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//�����Ʒ
	public String addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�����Ʒ");
		//������������
		request.setCharacterEncoding("utf-8");
		//��ȡ���в���
		Map<String, String[]> parameterMap = request.getParameterMap();
		//�Ѳ�����װ�ɶ���  ����beanutils-jar��
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_017.png");
			System.out.println(goods);
			//���÷����
			GoodsService goodsService = new GoodsService(); 
			goodsService.addGoods(goods);
			//��ת��GoodsListServlet,�����ݿ��ȡ���µ��б����ݣ�Ȼ��ת����main.jsp
			return "/GoodsServlet?action=getListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String editGoodsUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ǰ��Ʒ��id
		String id = request.getParameter("id");
		System.out.println("editGoodsUI"+id);
		try {
			// 1.��ȡ��ǰ��Ʒ
			GoodsService goodsService = new GoodsService();
			Goods goods = goodsService.getGoodsWithID(id);
			
			// ����Ʒд������
			request.setAttribute("goods", goods);

			// 2.��ȡ���з���
			CategoryService categoryService = new CategoryService();
			List<Category> allCategory = categoryService.findCategory();
			request.setAttribute("allCategory", allCategory);
			
			// ת����edit.jsp
			return "/admin/edit.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String editGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GoodsEditServlet");
		
		request.setCharacterEncoding("utf-8");
		//1.��ȡ���в���
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		//2.��װ��goods����
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_017.png");
			//3.����id��������
			//4.���÷���㣬��������
			GoodsService goodsService = new GoodsService();
			goodsService.updateGoods(goods);
			//System.out.println(goods);
			//��ת��GoodsListServlet��Ȼ��ת����main.jsp
			return "/GoodsServlet?action=getListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	}
