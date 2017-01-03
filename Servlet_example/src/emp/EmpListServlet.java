package emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.EmpController;
import vo.Emp;


public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		
		ArrayList<Emp> emps = new ArrayList<Emp>();
		EmpController empControl = new EmpController();
		
		emps = empControl.selectAllEmpList(request);
		
		// request�� ���� ��� ������ ����
		request.setAttribute("empList", emps);
			
		// JSP�� ����� ��û
		RequestDispatcher rd = request.getRequestDispatcher("/emp/EmpList.jsp");
		rd.include(request, response);
		
	}
}