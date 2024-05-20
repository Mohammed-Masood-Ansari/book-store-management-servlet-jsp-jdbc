<%@page import="com.jsp.EbookMangement.entity.Book_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.EbookMangement.dao.BookOrderDao"%>
<%@page import="com.jsp.EbookMangement.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>

</head>
<body>
	<c:if test="${ empty userobj }">

		<c:redirect url="login.jsp"></c:redirect>

	</c:if>

	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-1">
		<table class="table table-striped mt-3">
			<h3 class="text-center text-primary">Your Order</h3>
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment type</th>

				</tr>
			</thead>
			<tbody>
			<%
			User u = (User) session.getAttribute("userobj");

			BookOrderDao dao = new BookOrderDao();
			List<Book_Order> blist = dao.getBook(u.getEmail());
			
			for(Book_Order b:blist)
			
			{%>
				<tr>
					<th scope="row"><%=b.getOrderId() %></th>
					<td><%=b.getUsername() %></td>
					<td><%=b.getBookName() %></td>
					<td><%=b.getAuthor() %></td>
					<td><%=b.getPrice() %></td>
					<td><%=b.getPaymenttype() %></td>
				</tr>
					
			<%}
			%>
				
			</tbody>
		</table>

	</div>


</body>
</html>