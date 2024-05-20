<%@page import="com.jsp.EbookMangement.entity.Book_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.EbookMangement.dao.BookOrderDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:All Books</title>
<%@include file="allCss.jsp"%>

</head>
<body>
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<h3 class="text-center">Welcome To Orders All Book</h3>
	<table class="table">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">OrderId</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">phNo</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Payment type</th>

			</tr>
		</thead>
		<tbody>
			<%
			BookOrderDao dao = new BookOrderDao();
			List<Book_Order> blist = dao.getAllOrderBookDao();

			for (Book_Order b : blist)

			{
			%>
			<tr>
				<th scope="row"><%=b.getOrderId()%></th>
				<td><%=b.getUsername()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getFulladd()%></td>
				<td><%=b.getPhno()%></td>
				<td><%=b.getBookName()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getPaymenttype()%></td>
			</tr>

			<%
			}
			%>


		</tbody>
	</table>
</body>
</html>