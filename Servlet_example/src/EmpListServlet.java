
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class EmpListServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; // DB URL

		try {
			String qry = "select * from person where myname=?";
			
			Class.forName("oracle.jdbc.OracleDriver"); // JDBC DRIVER
	
			conn = DriverManager.getConnection(dbUrl, "yong", "1234");

			pstmt = conn.prepareStatement(qry);
			
			pstmt.setString(1, request.getParameter("name"));
			rs = pstmt.executeQuery();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>직원목록</title></head>");
			out.println("<body><h1>신상명세</h1>");
			while(rs.next()) {
				out.println(
					"Myname : " + 
					rs.getString("myname") + "<br>" +
					"Birth : " +
					rs.getDate("Birth") + "<br>" +
					"Email : " +
					rs.getString("email") + "<br>" +
					"Contatct : " +
					rs.getString("contact") + "<br>" +
					"Major : " + 
					rs.getString("major") + "<br>" +
					"Address : " +
					rs.getString("address") + "<br>" +
					"Motivation : " +
					rs.getString("motivation") + "<br>" +
					"Mumber : " +
					rs.getInt("num") + "<br>"			
				);
			}
			out.println("</body></html>");
		} catch (Exception e) {
			throw new ServletException(e);
			
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
}
