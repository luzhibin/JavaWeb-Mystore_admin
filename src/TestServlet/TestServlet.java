package TestServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServlet");
		/*String desPath = null;
		//���ղ���
		String action = request.getParameter("action");
		if("add".equals(action)) {
			//���
			System.out.println("���");
			desPath = add(request, response);
		}else if ("del".equals(action)) {
			//ɾ��
			System.out.println("ɾ��");
			desPath = del(request, response);
		}else if ("update".equals(action)) {
			//����
			System.out.println("����");
			desPath = update(request, response);
		}
		if(desPath != null) {
			request.getRequestDispatcher(desPath).forward(request, response);
		}
	}
	protected String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "add.jsp";
	}
	protected String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "del.jsp";
	}
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "update.jsp";*/
	}
}
