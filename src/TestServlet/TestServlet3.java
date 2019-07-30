package TestServlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet2")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TestServlet222");
		// 接收参数
		String action = request.getParameter("action");

		try {
			// 获取当前对象的字节码
			Class clazz = this.getClass();
			// this.getClass().getMethods();//获得此类实现的所有公有方法
			// 到当前字节码里获取action传入的方法，并且有request和response两个参数，赋值给method
			Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);

			// 判断是否有传入的方法,有就调用
			if (method != null) {
				/**
				 * JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法；这种动态获取的信息以及动态调用对象的方法的功能成为java语言的反射机制。
				 */
				// 有该方法，进行调用----Java反射机制 method.invoke()方法，用来执行某个的对象的目标方法
				String desPath = (String) method.invoke(this, request, response);

				// 判断是否为空
				if (desPath != null) {
					request.getRequestDispatcher(desPath).forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "add.jsp";
	}

	public String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "del.jsp";
	}

	public String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "update.jsp";
	}
}
