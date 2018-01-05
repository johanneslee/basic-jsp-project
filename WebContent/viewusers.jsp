<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>  
<html>  
<head>  
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">  
	<title>View Users</title>  
</head>  
<body>    
	<%@ page import="com.johanneslee.dao.UserDao, com.johanneslee.bean.*, java.util.*" %>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	<h1>Users List</h1>  
	<%  
		List<User> list=UserDao.getAllRecords();  
		request.setAttribute("list",list);  
	%>  	  
	<table border="1" width="90%">  
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th> 
			<th>Email</th>  
			<th>Edit</th>
			<th>Delete</th>
		</tr>  
		<c:forEach items="${list}" var="u">  
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getFirstName()} ${u.getLastName()}</td>
				<td>${u.getPhone()}</td>
				<td>${u.getEmail()}</td>
				<td><a href="editform.jsp?id=${u.getIdx()}">Edit</a></td>  
				<td><a href="deleteuser.jsp?id=${u.getIdx()}">Delete</a></td>
			</tr>  
		</c:forEach>  
	</table>  
	<br/><a href="adduserform.jsp">Add New User</a>  
</body>  
</html>  