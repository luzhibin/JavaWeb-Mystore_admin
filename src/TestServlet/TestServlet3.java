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
		// ���ղ���
		String action = request.getParameter("action");

		try {
			// ��ȡ��ǰ������ֽ���
			Class clazz = this.getClass();
			// this.getClass().getMethods();//��ô���ʵ�ֵ����й��з���
			// ����ǰ�ֽ������ȡaction����ķ�����������request��response������������ֵ��method
			Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);

			// �ж��Ƿ��д���ķ���,�о͵���
			if (method != null) {
				/**
				 * JAVA���������������״̬�У���������һ���࣬���ܹ�֪��������������Ժͷ�������������һ�����󣬶��ܹ�������������һ�����������ֶ�̬��ȡ����Ϣ�Լ���̬���ö���ķ����Ĺ��ܳ�Ϊjava���Եķ�����ơ�
				 */
				// �и÷��������е���----Java������� method.invoke()����������ִ��ĳ���Ķ����Ŀ�귽��
				String desPath = (String) method.invoke(this, request, response);

				// �ж��Ƿ�Ϊ��
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
