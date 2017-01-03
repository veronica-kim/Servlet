package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import connection.DBConnection;
import query.Emp.EmpQuery;
import vo.Emp;

public class EmpController {
	
	public ArrayList<Emp> selectAllEmpList(HttpServletRequest request){
		
		// return value 
		ArrayList<Emp> emps = new ArrayList<Emp>();
		Emp emp = null;
		
		DBConnection connect = new DBConnection();
		EmpQuery empQuery = new EmpQuery();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = connect.OracleConnect();
			
			pstmt = conn.prepareStatement(empQuery.getSelectAllEmpList());
			
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				emp = new Emp();
				
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.seteName(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setMgr(rs.getInt("MGR"));
				emp.setHireDate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getInt("SAL"));
				emp.setComm(rs.getInt("COMM"));
				emp.setDeptno(rs.getInt("DEPTNO"));
				
				emps.add(emp);
			}
		} catch (ClassNotFoundException ce){
			ce.printStackTrace();
		} catch (SQLException e) {
			// SQL Error Exception
			e.printStackTrace();
		} finally{
			try{ 
				if ( rs != null ) rs.close();
				if ( pstmt != null) pstmt.close();
				if ( conn != null) conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return emps;
	}
	
}