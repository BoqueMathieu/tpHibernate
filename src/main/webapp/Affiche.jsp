<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.nsis.bean.CityBean"%>
<%@ page import="com.nsis.bean.PersonBean"%>
<%@ page import="com.nsis.bo.Person"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table border="1">
		<tr>
			<td>Nom Ville:</td>
			<td>Maire:</td>
			<td>CP</td>
			<td>Nb Habitants:</td>
			<td>Firstname</td>
			<td>Lastname</td>
			<td>Email</td>
			<td>Phone</td>
		</tr>
		<%
 CityBean cityBean = (CityBean) request.getSession().getAttribute("city") ;%>
		<tr>
		<%for(PersonBean personbean : cityBean.getPersonnes()){%> 
			<td><%=cityBean.getName()%></td>
			<td><%=cityBean.getMayor()%></td>
			<td><%=cityBean.getPostalCode()%></td>
			<td><%=cityBean.getInHabitants()%></td>
			<td><%=personbean.getFirstName()%></td>
			<td><%=personbean.getLastName()%></td>
			<td><%=personbean.getMail()%></td>
			<td><%=personbean.getPhone()%></td>
			
		</tr>
		<% } %>

	</table>

</body>
</html>