package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;
import service.AdminService;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("adminServlet");
		//接收用户名和密码
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		//调用登录业务
		AdminService adminService = new AdminService();
		try {
			Admin admin = adminService.login(name,pwd);
			//1.把用户保存在session中
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			//2.跳转到后台首页
			//重定向是让浏览器跳转到指定位置  转发是服务器内部的跳转
			response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
			System.out.println("登陆成功");
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().equals("用户名或密码错误")) {
				//跳转回登录页面，回显错误信息
				request.setAttribute("error", e.getMessage());
				//转发，服务器内部的转发
				//相对于Webcontent目录来进行的
				request.getRequestDispatcher("admin/admin_login.jsp").forward(request, response);
				System.out.println("登录失败");
			}else {
				e.printStackTrace();
			}
		}
	}

}
