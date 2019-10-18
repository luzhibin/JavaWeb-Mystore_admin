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

	// 查询获取所有商品
	public String getListGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("查询所有商品");
		// 调用服务层
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.getAllGoods();
			// 集合反转
			java.util.Collections.reverse(allGoods);
			System.out.println(allGoods);
			// 把数据写到request域中
			request.setAttribute("allGoods", allGoods);
			return "admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//删除商品
	public String delGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("根据id删除指定商品");
		//1.接收参数id
		String id = request.getParameter("id");//参数id来源于a标签里的【?id=${goods.id}】<a>标签使用"?"传参
		//2.调动服务层，让其删除商品
		GoodsService goodsService = new GoodsService();	
		try {
			goodsService.deleteGoods(id);
			//转发
			return "/GoodsServlet?action=getListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	
	//添加商品的UI界面
	public String addGoodsUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加商品界面");
		//1.取出所有的分类
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findCategory();
			//2.把分类存到域中
			request.setAttribute("allCategory", allCategory);
			System.out.println("allCategory:"+allCategory);
			//3.转发到add.jsp
			return "admin/add.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//添加商品
	public String addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加商品");
		//处理乱码问题
		request.setCharacterEncoding("utf-8");
		//获取所有参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		//把参数封装成对象  导入beanutils-jar包
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_017.png");
			System.out.println(goods);
			//调用服务层
			GoodsService goodsService = new GoodsService(); 
			goodsService.addGoods(goods);
			//跳转到GoodsListServlet,从数据库获取最新的列表数据，然后转发到main.jsp
			return "/GoodsServlet?action=getListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String editGoodsUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取当前商品的id
		String id = request.getParameter("id");
		System.out.println("editGoodsUI"+id);
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
			return "/admin/edit.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String editGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GoodsEditServlet");
		
		request.setCharacterEncoding("utf-8");
		//1.获取所有参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		//2.封装成goods对象
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setImage("goods_017.png");
			//3.根据id更新数据
			//4.调用服务层，更新数据
			GoodsService goodsService = new GoodsService();
			goodsService.updateGoods(goods);
			//System.out.println(goods);
			//跳转到GoodsListServlet，然后转发到main.jsp
			return "/GoodsServlet?action=getListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	}
