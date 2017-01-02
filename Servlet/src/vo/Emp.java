package vo;

import java.util.Date;

public class Emp {
	int		empno;
	String 	eName;
	String 	job;
	int 	mgr;
	Date 	hireDate;
	int 	sal;
	int 	comm;
	int 	deptno;
	
	// setter getter method 한 번에 작성 ? alt + shift + s -> r
	
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public String geteName() {
		return eName;
	}
	
	public void seteName(String eName) {
		this.eName = eName;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getMgr() {
		return mgr;
	}
	
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public int getSal() {
		return sal;
	}
	
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	public int getComm() {
		return comm;
	}
	
	public void setComm(int comm) {
		this.comm = comm;
	}
	
	public int getDeptno() {
		return deptno;
	}
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
