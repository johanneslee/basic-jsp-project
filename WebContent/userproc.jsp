<%@page import="com.johanneslee.dao.UserDao"%>  
<jsp:useBean id="u" class="com.johanneslee.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
	int flag = Integer.parseInt(request.getParameter("flag"));
	
	switch(flag) {
		case 1 :
			UserDao.save(u);
			response.sendRedirect("viewusers.jsp");
			break;
		default :
	}
%>