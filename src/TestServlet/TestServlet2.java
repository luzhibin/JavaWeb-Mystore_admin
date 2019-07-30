package TestServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet2")
public class TestServlet2 extends BaseServlet {
	
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
