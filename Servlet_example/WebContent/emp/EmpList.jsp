<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.Emp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원 목록</title>
</head>
<body>
<h1>직원 목록</h1>
<table border="1">
<tr>
	<th width="100">EMPNO</th>
	<th width="100">ENAME</th>
	<th width="100">JOB</th>
	<th width="100">MGR</th>
	<th width="100">HIREDATE</th>
	<th width="100">SAL</th>
	<th width="100">COMM</th>
	<th width="100">DEPTNO</th>
</tr>

<% 
ArrayList<Emp> empList = (ArrayList<Emp>)request.getAttribute("empList");
for(Emp emp : empList) { 
%>

<tr>

	<td align ="center">< %= emp.getEmpno()    %></td> 
	<td align ="center">< %= emp.geteName()    %></td>
	<td align ="center">< %= emp.getJob()      %></td>
	<td align ="center">< %= emp.getMgr()      %></td>
	<td align ="center">< %= emp.getHireDate() %></td>
	<td align ="right" >< %= emp.getSal()      %></td>
	<td align ="right" >< %= emp.getComm()     %></td>
	<td align ="center">< %= emp.getDeptno()   %></td>

	
</tr>
<%} // end for %>
</table>
</body>
</html>
