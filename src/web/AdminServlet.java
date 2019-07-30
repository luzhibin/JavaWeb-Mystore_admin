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
		//�����û���������
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		//���õ�¼ҵ��
		AdminService adminService = new AdminService();
		try {
			Admin admin = adminService.login(name,pwd);
			//1.���û�������session��
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			//2.��ת����̨��ҳ
			//�ض��������������ת��ָ��λ��  ת���Ƿ������ڲ�����ת
			response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
			System.out.println("��½�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().equals("�û������������")) {
				//��ת�ص�¼ҳ�棬���Դ�����Ϣ
				request.setAttribute("error", e.getMessage());
				//ת�����������ڲ���ת��
				//�����WebcontentĿ¼�����е�
				request.getRequestDispatcher("admin/admin_login.jsp").forward(request, response);
				System.out.println("��¼ʧ��");
			}else {
				e.printStackTrace();
			}
		}
	}

}
