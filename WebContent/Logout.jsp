<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
	response.addHeader("Pragma", "no-cache"); 
	response.addDateHeader ("Expires", 0);
%>

<%
	session = request.getSession();
	String username = "" ;
	if(session.getAttribute("username")==null || session.getAttribute("username")==""){
		response.sendRedirect("login.jsp");
	}
	else{
		username = session.getAttribute("username").toString();
	}
 %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log out</title>
</head>
<body>
<%	
	if(session.getAttribute("username")!=null){
		session.removeAttribute("username");
		request.getSession(false);
		session.setAttribute("username",null);
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

%>


</body>
</html>